package com.ff.productservice.controller;

import com.ff.productservice.domain.dto.ProductDto;
import com.ff.productservice.service.ProductService;
import com.ff.productservice.utils.ProductUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Tag(name = "Product", description = "Product management")
public class ProductController {

  private final ProductService service;

  @PostMapping()
  @Operation(summary = "Create or update product", method = "POST")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ProductDto> saveProduct(
      @Valid @RequestBody ProductDto dto
  ) {
    return ResponseEntity.ok(service.createUpdateProduct(dto));
  }

  @PatchMapping()
  @Operation(summary = "Update product", method = "PATCH")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ProductDto> updateProduct(
      @Valid @RequestBody ProductDto dto
  ) {
    return ResponseEntity.ok(service.updateProduct(dto));
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Delete product", method = "DELETE")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> deleteProduct(
      @PathVariable Long id
  ) {
    service.deleteProduct(id);
    return ResponseEntity.ok("Product successfully deleted!");
  }

  @GetMapping(value = "/{id}")
  @Operation(summary = "Get single product", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ProductDto> getProductById(
      @PathVariable Long id
  ) {
    System.out.println("@PathVariable Long id");
    System.out.println(id);
    return ResponseEntity.ok(service.getProductById(id));
  }

  @GetMapping()
  @Operation(summary = "Get all products", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<ProductDto>> getAllProducts() {
    return ResponseEntity.ok(service.getAllProducts());
  }

  @GetMapping("/pagination")
  @Operation(summary = "Get all products with pagination", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Page<ProductDto>> getAllProducts(
      @Parameter(description = "Pagination parameters",
          example = "{ \"page\": 0, \"size\": 10, \"sort\": \"id,asc\" }",
          name = "pageable")
      @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable
  ) {
    return ResponseEntity.ok(service.getPagedProducts(pageable));
  }

}
