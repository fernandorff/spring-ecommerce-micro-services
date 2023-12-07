package com.ff.stockservice.controller;

import com.ff.stockservice.domain.dto.*;
import com.ff.stockservice.service.StockService;
import com.ff.stockservice.utils.StockUtils;
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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
@Tag(name = "Stock", description = "Stock management")
public class StockController {

  private final StockService service;

  @PostMapping
  @Operation(summary = "Create stock", method = "POST")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<StockDto> saveStock(
      @Valid @RequestBody StockDto dto
  ) {
    return ResponseEntity.ok(service.createStock(dto));
  }

  @PutMapping
  @Operation(summary = "Update stock description or price", method = "PUT")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<StockDto> updateStock(
      @Valid @RequestBody StockUpdateDto dto
  ) {
    return ResponseEntity.ok(service.updateStock(dto));
  }

  @PatchMapping
  @Operation(summary = "Refill stock. Requires number of items bought and their unit price.")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<StockDto> refillStock(
      @Valid @RequestBody StockRefillDto dto
  ) {
    return ResponseEntity.ok(service.refillStock(dto));
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Delete stock", method = "DELETE")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<StockDto> deleteStock(
      @PathVariable Long id
  ) {
    return ResponseEntity.ok(service.deleteStock(id));
  }

  @GetMapping(value = "/{id}")
  @Operation(summary = "Get single stock", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<StockDto> getStockById(
      @PathVariable Long id
  ) {
    var dto = StockUtils.toDto(service.getStockById(id));
    return ResponseEntity.ok(dto);
  }

  @GetMapping("/by-product-id/first-cheapest-available/{productId}")
  @Operation(summary = "Get first cheapest available stock by product id", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<StockDto> getFirstCheapestAvailableStockByProductId(
      @PathVariable Long productId
  ) {
    return ResponseEntity.ok(service.getFirstCheapestAvailableStockByProductId(productId));
  }

  @GetMapping("/by-product-id/{productId}")
  @Operation(summary = "Get stocks by product id", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<StockDto>> getAllStocksByProductId(
      @PathVariable Long productId
  ) {
    return ResponseEntity.ok(service.getAllStocksByProductId(productId));
  }

  @GetMapping()
  @Operation(summary = "Get all stocks", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<StockDto>> getAllStocks() {
    return ResponseEntity.ok(service.getAllStocks());
  }

  @GetMapping("/active")
  @Operation(summary = "Get all active stocks", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<StockDto>> getAllActiveStocks() {
    return ResponseEntity.ok(service.getAllActiveStocks());
  }

  @GetMapping("/pagination")
  @Operation(summary = "Get all stocks with pagination", method = "GET")
  @ResponseStatus(HttpStatus.OK)

  public ResponseEntity<Page<StockDto>> getAllStocks(
      @Parameter(description = "Pagination parameters",
          example = "{ \"page\": 0, \"size\": 10, \"sort\": \"id,asc\" }",
          name = "pageable")
      @PageableDefault(sort = "id") Pageable pageable
  ) {
    return ResponseEntity.ok(service.getPagedStocks(pageable));
  }

  @PostMapping("execute-order")
  @Operation(summary = "Execute order to update stock", method = "PATCH")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<StockDto>> executeOrder(
      @Valid @RequestBody OrderDto dto
  ) {
    return ResponseEntity.ok(service.executeOrder(dto));
  }
}
