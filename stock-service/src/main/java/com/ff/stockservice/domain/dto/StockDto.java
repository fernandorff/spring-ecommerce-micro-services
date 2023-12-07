package com.ff.stockservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Schema(description = "Stock data transfer object")
@Builder
public class StockDto {

  @Schema(description = "Unique identifier")
  private Long id;

  @Schema(description = "Description", example = "Promotional stock")
  private String description;

  @Schema(description = "Available amount", example = "5")
  @Min(value = 0, message = "Available amount must not be less than 0")
  private Integer availableAmount = 0;

  @Schema(description = "Product Id", example = "5")
  @Min(value = 0, message = "Product Id invalid")
  private Long productId;

  @Schema(description = "Price the item is being sold for.", example = "19.99")
  @Min(value = 0, message = "Price can't be negative")
  private Double price = 0.0;

  @Schema(description = "How much was paid for each item", example = "10.00")
  @Min(value = 0, message = "Cost can't be negative")
  private Double cost = 0.0;

  @Schema(description = "Indicates if the stock is active for sale.", example = "false")
  private Boolean isActive = false;

}
