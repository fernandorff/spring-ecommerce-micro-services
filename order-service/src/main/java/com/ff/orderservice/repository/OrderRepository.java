package com.ff.orderservice.repository;

import com.ff.orderservice.domain.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

  @Override
  Page<Order> findAll(Pageable pageable);
}
