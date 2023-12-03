package com.ff.stockservice.utils;

import com.ff.stockservice.domain.dto.StockDto;
import com.ff.stockservice.domain.entity.Stock;
import org.springframework.beans.BeanUtils;

public class StockUtils {

    public static Stock toEntity(StockDto dto) {
        var entity = new Stock();

        BeanUtils.copyProperties(dto, entity);

        return entity;
    }

    public static StockDto toDto(Stock entity) {
        var dto = new StockDto();

        BeanUtils.copyProperties(entity, dto);

        return dto;
    }
}
