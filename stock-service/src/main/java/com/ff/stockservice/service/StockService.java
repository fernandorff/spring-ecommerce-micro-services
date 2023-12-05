package com.ff.stockservice.service;


import com.ff.stockservice.domain.dto.*;
import com.ff.stockservice.domain.entity.Stock;
import com.ff.stockservice.repository.StockRepository;
import com.ff.stockservice.utils.StockUtils;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class StockService {

  private final StockRepository repository;

  private final ProductApiCommunicationService productApiCommunicationService;

  public StockDto createStock(StockDto dto) {
    var entity = StockUtils.toEntity(dto);

    try {
      productApiCommunicationService.getProductById(dto.getProductId());
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "Product not found with id: " + dto.getProductId());
    }

    entity = repository.save(entity);

    return StockUtils.toDto(entity);
  }

  public StockDto updateStock(StockUpdateDto dto) {

    var stock = repository.findById(dto.getId()).
        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Stock with id: " + dto.getId() + " not found"));

    var newDescription = dto.getDescription();
    if (newDescription != null && !newDescription.isBlank()) {
      stock.setDescription(newDescription);
    }

    var newPrice = dto.getPrice();
    if (newPrice != null && newPrice >= 0) {
      stock.setPrice(newPrice);
    }

    return StockUtils.toDto(repository.save(stock));
  }

  public StockDto refillStock(StockRefillDto dto) {
    var stock = repository.findById(dto.getId()).
        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Stock with id: " + dto.getId() + " not found"));

    var currentAmount = stock.getAvailableAmount();
    var currentCost = stock.getCost();

    var newAmount = currentAmount + dto.getBoughtAmount();
    var newCost =
        ((currentAmount * currentCost) + (dto.getBoughtAmount() * dto.getCost())) / newAmount;

    stock.setAvailableAmount(newAmount);
    stock.setCost(newCost);

    return StockUtils.toDto(repository.save(stock));
  }

  public void deleteStock(Long id) {
    repository.deleteById(id);
  }

  public Stock getStockById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Stock not found with id: " + id));
  }

  public StockDto getStockByProductId(Long productId) {
    Optional<Stock> stockOptional = repository
        .findAllByProductIdAndAvailableAmountGreaterThanOrderByPriceAsc(productId, 0)
        .stream()
        .findFirst();

    if (stockOptional.isPresent()) {
      return StockUtils.toDto(stockOptional.get());
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "Stock not found for productId: " + productId);
    }
  }

  public List<StockDto> getAllStocks() {
    return repository.findAll().stream().map(StockUtils::toDto).collect(Collectors.toList());
  }

  public Page<StockDto> getPagedStocks(Pageable pageable) {
    Page<Stock> StocksPage = repository.findAll(pageable);
    return StocksPage.map(StockUtils::toDto);
  }

  @SneakyThrows
  @Transactional
  public List<StockDto> executeOrder(OrderDto orderDto) {
    var updatedStocksList = new ArrayList<Stock>();

    for (OrderItemDto orderItem : orderDto.getOrderItems()) {
      var stock = getStockById(orderItem.getStockId());

      System.out.println(stock.toString());

      ProductDto productDto;
      try {
        productDto = productApiCommunicationService.getProductById(stock.getProductId());
      } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Product not found on stock with id: " + stock.getProductId());
      }

      if (orderItem.getPurchasedQuantity() > stock.getAvailableAmount()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
            "Insufficient stock for product with id: " + productDto.getId());
      }

      stock.setAvailableAmount(stock.getAvailableAmount() - orderItem.getPurchasedQuantity());

      var updatedStock = repository.save(stock);

      updatedStocksList.add(updatedStock);
    }

    return updatedStocksList.stream().map(StockUtils::toDto).collect(Collectors.toList());
  }

}
