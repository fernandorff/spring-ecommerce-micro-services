package com.ff.productservice.service;

import com.ff.productservice.domain.dto.ProductDto;
import com.ff.productservice.domain.entity.Product;
import com.ff.productservice.repository.ProductRepository;
import com.ff.productservice.utils.ProductUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public ProductDto createUpdateProduct(ProductDto dto) {
        var entity = ProductUtils.toEntity(dto);
        entity = repository.save(entity);
        return ProductUtils.toDto(entity);
    }

    public ProductDto updateProduct(ProductDto dto) {
        getProductById(dto.getId());
        return createUpdateProduct(dto);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    public List<ProductDto> getAllProducts() {
        return repository.findAll().stream().map(ProductUtils::toDto).collect(Collectors.toList());
    }

    public Page<ProductDto> getPagedProducts(Pageable pageable) {
        Page<Product> ProductsPage = repository.findAll(pageable);
        return ProductsPage.map(ProductUtils::toDto);
    }
}
