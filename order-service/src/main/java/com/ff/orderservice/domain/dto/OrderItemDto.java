package com.ff.orderservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Schema(description = "Order data transfer object")
@ToString
public class OrderItemDto {

  @NotNull(message = "Stock id is required")
  @Schema(description = "Stock id", example = "1")
  Long stockId;
  @Min(message = "Minimun purchased quantity is 1", value = 1)
  @Schema(description = "Purchased quantity", example = "1")
  Integer purchasedQuantity;
  @Schema(description = "Unique identifier")
  private Long id;
  @NotNull(message = "Product id is required")
  @Schema(description = "Product id", example = "1")
  private Long productId;
  @NotNull(message = "Product price is required")
  @Schema(description = "Product's price", example = "19.99")
  private Double price;
  @Schema(description = "Product image URL")
  private String productImageUrl;

  @Schema(description = "Purchased product name")
  private String productName;

  @Schema(description = "Purchased product description")
  private String productDescription;
}
