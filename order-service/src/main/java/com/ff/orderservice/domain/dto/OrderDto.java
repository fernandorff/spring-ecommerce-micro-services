package com.ff.orderservice.domain.dto;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;


@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Schema(description = "Order data transfer object")
@ToString
public class OrderDto {

  @ArraySchema(items = @Schema(description = "List of order items", implementation = OrderItemDto.class))
  @UniqueElements(message = "Order items can't be repeated")
  @Valid
  List<OrderItemDto> orderItems;
  @Schema(description = "Unique identifier")
  private Long id;
  @Schema(description = "Purchase date", example = "2022-12-12T12:00:00", defaultValue = "2022-12-12T12:00:00")
  private LocalDateTime orderDate;
}
