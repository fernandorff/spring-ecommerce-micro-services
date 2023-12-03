package com.ff.orderservice.controller;

import com.ff.orderservice.domain.dto.OrderDto;
import com.ff.orderservice.service.OrderService;
import com.ff.orderservice.utils.OrderMapper;
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
@RequestMapping("/order")
@RequiredArgsConstructor
@Tag(name = "Order", description = "Order management")
public class OrderController {

  private final OrderService service;

  @PostMapping()
  @Operation(summary = "Create or update order", method = "POST")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<OrderDto> saveOrder(
      @Valid @RequestBody OrderDto dto
  ) {
    return ResponseEntity.ok(service.createUpdateOrder(dto));
  }

  @PatchMapping()
  @Operation(summary = "Update order", method = "PATCH")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<OrderDto> updateOrder(
      @Valid @RequestBody OrderDto dto
  ) {
    return ResponseEntity.ok(service.updateOrder(dto));
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Delete order", method = "DELETE")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> deleteOrder(
      @PathVariable Long id
  ) {
    service.deleteOrder(id);
    return ResponseEntity.ok("Order successfully deleted!");
  }

  @GetMapping(value = "/{id}")
  @Operation(summary = "Get single order", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<OrderDto> getOrderById(
      @PathVariable Long id
  ) {
    var dto = OrderMapper.MAPPER.toOrderDto(service.getOrderById(id));
    return ResponseEntity.ok(dto);
  }

  @GetMapping()
  @Operation(summary = "Get all orders", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<OrderDto>> getAllOrders() {
    return ResponseEntity.ok(service.getAllOrders());
  }

  @GetMapping("/pagination")
  @Operation(summary = "Get all orders with pagination", method = "GET")
  @ResponseStatus(HttpStatus.OK)

  public ResponseEntity<Page<OrderDto>> getAllOrders(
      @Parameter(description = "Pagination parameters",
          example = "{ \"page\": 0, \"size\": 10, \"sort\": \"id,asc\" }",
          name = "pageable")
      @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable
  ) {
    return ResponseEntity.ok(service.getPagedOrders(pageable));
  }
}
