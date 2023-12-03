package com.ff.productservice.utils;

import com.ff.productservice.domain.dto.ProductDto;
import com.ff.productservice.domain.entity.Product;
import org.springframework.beans.BeanUtils;

public class ProductUtils {

    public static Product toEntity(ProductDto dto) {
        var entity = new Product();

        BeanUtils.copyProperties(dto, entity);

        return entity;
    }

    public static ProductDto toDto(Product entity) {
        var dto = new ProductDto();

        BeanUtils.copyProperties(entity, dto);

        return dto;
    }
}
