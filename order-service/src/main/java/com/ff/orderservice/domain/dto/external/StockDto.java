package com.ff.orderservice.domain.dto.external;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Schema(description = "Stock data transfer object")
@ToString
public class StockDto {

  @Schema(description = "Unique identifier")
  private Long id;

  @Schema(description = "Description", example = "Example stock")
  private String description;

  @Schema(description = "Available amount", example = "5")
  @Min(value = 0, message = "Available amount must not be less than 0")
  private Integer availableAmount;

  @Schema(description = "Product Id", example = "5")
  @Min(value = 0, message = "Product Id invalid")
  private Long productId;
}
