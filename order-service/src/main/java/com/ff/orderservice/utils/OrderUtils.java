package com.ff.orderservice.utils;

import com.ff.orderservice.domain.dto.OrderDto;
import com.ff.orderservice.domain.dto.OrderItemDto;
import com.ff.orderservice.domain.entity.Order;
import com.ff.orderservice.domain.entity.OrderItem;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;

public class OrderUtils {

  public static Order toEntity(OrderDto dto) {
    var entity = new Order();

    BeanUtils.copyProperties(dto, entity);

    if (dto.getOrderItems() != null) {
      List<OrderItem> orderItems = dto.getOrderItems().stream()
          .map(OrderItemUtils::toEntity)
          .collect(Collectors.toList());
      entity.setOrderItems(orderItems);
    }

    return entity;
  }

  public static OrderDto toDto(Order entity) {
    var dto = new OrderDto();

    BeanUtils.copyProperties(entity, dto);

    if (entity.getOrderItems() != null) {
      List<OrderItemDto> orderItemDtos = entity.getOrderItems().stream()
          .map(OrderItemUtils::toDto)
          .collect(Collectors.toList());
      dto.setOrderItems(orderItemDtos);
    }

    return dto;
  }
}
