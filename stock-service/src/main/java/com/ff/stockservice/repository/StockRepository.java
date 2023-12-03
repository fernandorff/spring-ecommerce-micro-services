package com.ff.stockservice.repository;

import com.ff.stockservice.domain.entity.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
    @Override
    Page<Stock> findAll(Pageable pageable);
}
