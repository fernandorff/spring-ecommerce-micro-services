package com.ff.orderservice.utils;

import com.ff.orderservice.domain.dto.OrderItemDto;
import com.ff.orderservice.domain.entity.OrderItem;
import org.springframework.beans.BeanUtils;

public class OrderItemUtils {

  public static OrderItem toEntity(OrderItemDto dto) {
    var entity = new OrderItem();

    BeanUtils.copyProperties(dto, entity);

    return entity;
  }

  public static OrderItemDto toDto(OrderItem entity) {
    var dto = new OrderItemDto();

    BeanUtils.copyProperties(entity, dto);

    return dto;
  }
}
