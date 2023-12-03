package com.ff.stockservice.controller;

import com.ff.stockservice.domain.dto.StockDto;
import com.ff.stockservice.domain.dto.external.OrderDto;
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
@RequestMapping("/stock")
@RequiredArgsConstructor
@Tag(name = "Stock", description = "Stock management")
public class StockController {

  private final StockService service;

  @PostMapping()
  @Operation(summary = "Create or update stock", method = "POST")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<StockDto> saveStock(
      @Valid @RequestBody StockDto dto
  ) {
    return ResponseEntity.ok(service.createUpdateStock(dto));
  }

  @PatchMapping()
  @Operation(summary = "Update stock", method = "PATCH")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<StockDto> updateStock(
      @Valid @RequestBody StockDto dto
  ) {
    return ResponseEntity.ok(service.updateStock(dto));
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Delete stock", method = "DELETE")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> deleteStock(
      @PathVariable Long id
  ) {
    service.deleteStock(id);
    return ResponseEntity.ok("Stock successfully deleted!");
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

  @GetMapping()
  @Operation(summary = "Get all stocks", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<StockDto>> getAllStocks() {
    return ResponseEntity.ok(service.getAllStocks());
  }

  @GetMapping("/pagination")
  @Operation(summary = "Get all stocks with pagination", method = "GET")
  @ResponseStatus(HttpStatus.OK)

  public ResponseEntity<Page<StockDto>> getAllStocks(
      @Parameter(description = "Pagination parameters",
          example = "{ \"page\": 0, \"size\": 10, \"sort\": \"id,asc\" }",
          name = "pageable")
      @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable
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
