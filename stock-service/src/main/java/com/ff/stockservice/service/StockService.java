package com.ff.stockservice.service;


import com.ff.stockservice.domain.dto.StockDto;
import com.ff.stockservice.domain.entity.Stock;
import com.ff.stockservice.repository.StockRepository;
import com.ff.stockservice.utils.StockUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository repository;

    public StockDto createUpdateStock(StockDto dto) {
        var entity = StockUtils.toEntity(dto);
        entity = repository.save(entity);
        return StockUtils.toDto(entity);
    }

    public StockDto updateStock(StockDto dto) {
        getStockById(dto.getId());
        return createUpdateStock(dto);
    }

    public void deleteStock(Long id) {
        repository.deleteById(id);
    }

    public Stock getStockById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock not found"));
    }

    public List<StockDto> getAllStocks() {
        return repository.findAll().stream().map(StockUtils::toDto).collect(Collectors.toList());
    }

    public Page<StockDto> getPagedStocks(Pageable pageable) {
        Page<Stock> StocksPage = repository.findAll(pageable);
        return StocksPage.map(StockUtils::toDto);
    }
}
