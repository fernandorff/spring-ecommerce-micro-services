package com.ff.stockservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Schema(description = "Stock refill data transfer object")
public class StockRefillDto {
    @Schema(description = "Unique identifier")
    @NotNull
    private Long id;

    @Schema(description = "Bought amount", example = "5")
    @Min(value = 1, message = "Bought amount must not be less than 1")
    private Integer boughtAmount;

    @Schema(description = "How much was paid for each item", example = "10.00")
    @Min(value = 0, message = "Cost can't be negative")
    private Double cost;
}
