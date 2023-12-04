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
@Schema(description = "Stock update data transfer object. Used to update price or description.")
public class StockUpdateDto {

    @Schema(description = "Unique identifier")
    @NotNull
    private Long id;

    @Schema(description = "Description", example = "Promotional stock")
    private String description;

    @Schema(description = "Price the item is being sold for.", example = "19.99")
    @Min(value = 0, message = "Price can't be negative")
    private Double price;
}
