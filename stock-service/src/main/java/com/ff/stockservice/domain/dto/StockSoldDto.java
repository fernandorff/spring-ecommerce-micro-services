package com.ff.stockservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Schema(description = "Stock item sold data transfer object")
public class StockSoldDto {
    @Schema(description = "Sold amount", example = "5")
    @Min(value = 0, message = "Sold amount must not be less than 0")
    private Integer soldAmount;
}
