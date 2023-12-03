package com.ff.orderservice.service;

import com.ff.orderservice.domain.dto.StockDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class StockApiCommunicationService {

  @Value("${stock.service.url}")
  private String stockServiceUrl;

  private final RestTemplate restTemplate;

  public StockDto getStockById(Long id) {
    String url = stockServiceUrl + "/stock/" + id;
    return restTemplate.getForObject(url, StockDto.class);
  }
}
