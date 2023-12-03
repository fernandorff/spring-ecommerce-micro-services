package com.ff.orderservice.service;


import com.ff.orderservice.domain.dto.OrderDto;
import com.ff.orderservice.domain.dto.OrderItemDto;
import com.ff.orderservice.domain.entity.Order;
import com.ff.orderservice.domain.entity.OrderItem;
import com.ff.orderservice.repository.OrderRepository;
import com.ff.orderservice.utils.OrderMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository repository;

  private final StockApiCommunicationService stockApiCommunicationService;

  private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

  @Transactional
  public OrderDto createUpdateOrder(OrderDto dto) {
    validateUniqueStockIds(dto.getOrderItems());

    var entity = OrderMapper.MAPPER.toOrder(dto);

    List<OrderItem> orderItems = new ArrayList<>();
    for (OrderItemDto itemDto : dto.getOrderItems()) {
      try {
        stockApiCommunicationService.getStockById(itemDto.getStockId());
      } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock not found");
      }
      OrderItem orderItemEntity = OrderMapper.MAPPER.toOrderItem(itemDto);
      orderItemEntity.setOrder(entity);
      orderItems.add(orderItemEntity);
    }

    entity.setOrderItems(orderItems);

    entity = repository.save(entity);

    return OrderMapper.MAPPER.toOrderDto(entity);
  }

  @Transactional
  public OrderDto updateOrder(OrderDto dto) {
    getOrderById(dto.getId());
    return createUpdateOrder(dto);
  }

  public void deleteOrder(Long id) {
    repository.deleteById(id);
  }

  public Order getOrderById(Long id) {

    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
  }

  public List<OrderDto> getAllOrders() {
    return repository.findAll().stream().map(OrderMapper.MAPPER::toOrderDto)
        .collect(Collectors.toList());
  }

  public Page<OrderDto> getPagedOrders(Pageable pageable) {
    Page<Order> OrdersPage = repository.findAll(pageable);
    return OrdersPage.map(OrderMapper.MAPPER::toOrderDto);
  }

  private void validateUniqueStockIds(@Valid List<OrderItemDto> orderItems) {
    Set<Long> uniqueStockIds = new HashSet<>();

    for (OrderItemDto itemDto : orderItems) {
      Long stockId = itemDto.getStockId();

      if (stockId != null) {
        if (!uniqueStockIds.add(stockId)) {
          throw new ResponseStatusException(
              HttpStatus.BAD_REQUEST,
              "Duplicate stock id found: " + stockId
          );
        }
      } else {
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "Stock id invalid"
        );
      }
    }
  }
}
