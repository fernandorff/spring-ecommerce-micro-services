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
@Schema(description = "Order data transfer object")
public class OrderItemDto {

  @NotNull(message = "Stock id is required")
  @Schema(description = "Stock id", example = "1")
  Long stockId;

  @Min(message = "Minimun purchased quantity is 1", value = 1)
  @Schema(description = "Purchased quantity", example = "1")
  Integer purchasedQuantity;
}
