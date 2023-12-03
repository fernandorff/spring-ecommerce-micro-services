package com.ff.stockservice.domain.dto.external;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;


@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Schema(description = "Order data transfer object")
public class OrderDto {

  @Schema(description = "Unique identifier")
  private Long id;

  @Valid
  @ArraySchema(items = @Schema(description = "List of order items", implementation = OrderItemDto.class))
  @UniqueElements(message = "Order items can't be repeated")
  List<OrderItemDto> orderItems;

  @Schema(description = "Purchase date", example = "2022-12-12T12:00:00", defaultValue = "2022-12-12T12:00:00")
  private LocalDateTime orderDate;
}
