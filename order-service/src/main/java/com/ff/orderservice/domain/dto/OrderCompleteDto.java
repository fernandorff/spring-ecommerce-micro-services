package com.ff.orderservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Schema(description = "Order data transfer object")
public class OrderCompleteDto {

  private Long orderId;

  private List<Long> orderProductIds;

  private Integer productsAmount;

  private Double totalPrice;

  private LocalDateTime orderDate;
}
