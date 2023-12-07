package com.ff.orderservice.repository;

import com.ff.orderservice.domain.entity.Order;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

  @Override
  @NotNull
  Page<Order> findAll(@NotNull Pageable pageable);
}
