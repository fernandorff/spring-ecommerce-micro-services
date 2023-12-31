package com.ff.productservice.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ff.productservice.domain.dto.ProductDto;
import com.ff.productservice.domain.entity.Product;
import com.ff.productservice.repository.ProductRepository;
import com.ff.productservice.utils.ProductUtils;
import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository repository;

  private final AmazonS3 amazonS3;

  public ProductDto createUpdateProduct(ProductDto dto) {
    var entity = ProductUtils.toEntity(dto);

    entity = repository.save(entity);

    if (dto.getImageFileBase64() != null && !dto.getImageFileBase64().isBlank()
        && !dto.getImageFileBase64()
        .isEmpty()) {
      var imageName = "product-" + entity.getId();
      var imageUrl = saveImageInBucketS3AndReturnUrl(dto.getImageFileBase64(),
          entity.getId() + "-" + imageName + ".jpeg");
      entity.setImageUrl(imageUrl);
    }

    System.out.println(entity.getImageUrl());

    entity = repository.save(entity);

    return ProductUtils.toDto(entity);
  }

  public ProductDto updateProduct(ProductDto dto) {
    getProductById(dto.getId());
    return createUpdateProduct(dto);
  }

  public ProductDto deleteProduct(Long id) {
    var product = repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    repository.delete(product);
    return ProductUtils.toDto(product);
  }

  public ProductDto getProductById(Long id) {
    return ProductUtils.toDto(repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found")));
  }

  public List<ProductDto> getAllProducts() {
    return repository.findAll().stream().map(ProductUtils::toDto).collect(Collectors.toList());
  }

  public Page<ProductDto> getPagedProducts(Pageable pageable) {
    Page<Product> ProductsPage = repository.findAll(pageable);
    return ProductsPage.map(ProductUtils::toDto);
  }

  public String saveImageInBucketS3AndReturnUrl(String image, String imageName) {

    var bucket = "paradis-product-images";

    var region = "us-east-2";

    byte[] imgToInsert = Base64.getDecoder().decode(image);

    ObjectMetadata meta = new ObjectMetadata();
    meta.setContentLength(Long.valueOf(imgToInsert.length));
    meta.setContentType("image/jpeg");

    ByteArrayInputStream inputStream = new ByteArrayInputStream(imgToInsert);

    amazonS3.putObject(new PutObjectRequest(bucket, imageName, inputStream, meta));

    return "https://" + bucket + ".s3." + region + ".amazonaws.com/" + imageName;
  }
}
