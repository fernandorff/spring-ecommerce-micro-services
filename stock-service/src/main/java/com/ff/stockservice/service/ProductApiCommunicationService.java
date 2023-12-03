package com.ff.stockservice.service;

import com.ff.stockservice.domain.dto.external.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProductApiCommunicationService {

  private final RestTemplate restTemplate;
  @Value("${product.service.url}")
  private String productServiceUrl;

  public ProductDto getProductById(Long id) {
    String url = productServiceUrl + "/product/" + id;
    return restTemplate.getForObject(url, ProductDto.class);
  }
}
