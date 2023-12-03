package com.ff.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ff.orderservice.domain.dto.OrderDto;
import com.ff.orderservice.domain.dto.StockDto;
import jakarta.validation.ValidationException;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class StockApiCommunicationService {

  private final RestTemplate restTemplate;

  @Value("${stock.service.url}")
  private String stockServiceUrl;

  public StockDto getStockById(Long id) {
    String url = stockServiceUrl + "/stock/" + id;
    return restTemplate.getForObject(url, StockDto.class);
  }

  public List<StockDto> executeOrder(OrderDto dto) {
    String url = stockServiceUrl + "/stock/execute-order";

    ParameterizedTypeReference<List<StockDto>> responseType = new ParameterizedTypeReference<List<StockDto>>() {
    };

    try {
      List<StockDto> stockDtos = restTemplate.exchange(
          url,
          HttpMethod.POST,
          new HttpEntity<>(dto),
          responseType
      ).getBody();

      Objects.requireNonNull(stockDtos)
          .forEach(stockDto -> System.out.println(stockDto.getDescription()));

      return stockDtos;
    } catch (HttpClientErrorException e) {
      System.out.println("catch (HttpClientErrorException e)");
      System.out.println(e.getMessage());
      System.out.println(e.getStatusCode());

      try {
        String responseBody = e.getResponseBodyAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);

        int status = jsonNode.get("status").asInt();
        String errorMessage = jsonNode.get("message").asText();

        System.out.println(status);
        System.out.println(errorMessage);

        if (status == HttpStatus.NOT_FOUND.value()) {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        } else if (status == HttpStatus.BAD_REQUEST.value()) {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        } else {
          throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
              "Internal server error");
        }
      } catch (JsonProcessingException ex) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
            "An unexpected error occurred during error handling");
      }

    } catch (HttpServerErrorException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getStatusCode());
      System.out.println(e.getCause());

      System.out.println("} catch (HttpServerErrorException e) {");

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "External service error");
    } catch (ValidationException e) {
      System.out.println("} catch (ValidationException e) {");

      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    } catch (Exception e) {
      System.out.println("} catch (Exception e) {");

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
          "An unexpected error occurred");
    }
  }
}
