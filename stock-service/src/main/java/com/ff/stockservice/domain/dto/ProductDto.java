package com.ff.stockservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Schema(description = "Product data transfer object")
public class ProductDto {

  @Schema(description = "Unique identifier for the product")
  private Long id;

  @Schema(description = "Name of the product", example = "Example Product")
  private String name;

  @Schema(description = "Price of the product", example = "19.99")
  private Double price;
}
