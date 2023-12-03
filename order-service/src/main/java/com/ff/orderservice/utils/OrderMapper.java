package com.ff.orderservice.utils;

import com.ff.orderservice.domain.dto.OrderDto;
import com.ff.orderservice.domain.dto.OrderItemDto;
import com.ff.orderservice.domain.entity.Order;
import com.ff.orderservice.domain.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

  OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

  Order toOrder(OrderDto orderDto);

  OrderItem toOrderItem(OrderItemDto orderItemDto);

  OrderDto toOrderDto(Order order);

  OrderItemDto toOrderItemDto(OrderItem orderItem);
}