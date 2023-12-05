package com.ff.orderservice.service.sink;


import com.ff.orderservice.domain.dto.OrderDto;
import lombok.Getter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class OrderSink {

  private static OrderSink ORDER_SINK_INSTANCE = null;

  private Sinks.Many<OrderDto> sink;

  @Getter
  private Flux<OrderDto> flux;

  private OrderSink() {
    sink = Sinks.many().replay().limit(1);
    flux = this.sink.asFlux();
  }

  public static OrderSink getOrderSinkInstance() {
    if (ORDER_SINK_INSTANCE == null) {
      ORDER_SINK_INSTANCE = new OrderSink();
    }
    return ORDER_SINK_INSTANCE;
  }

  public void publishOrderCompleteMessage(OrderDto orderCompleteDto) {
    this.sink.tryEmitNext(orderCompleteDto);
  }
}
