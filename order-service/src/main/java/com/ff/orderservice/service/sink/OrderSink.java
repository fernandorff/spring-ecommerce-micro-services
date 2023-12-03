package com.ff.orderservice.service.sink;


import com.ff.orderservice.domain.dto.OrderCompleteDto;
import lombok.Getter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class OrderSink {

  private static OrderSink ORDER_SINK_INSTANCE = null;

  private Sinks.Many<OrderCompleteDto> sink;

  @Getter
  private Flux<OrderCompleteDto> flux;

  private OrderSink() {
    sink = Sinks.many().replay().limit(2);
    flux = this.sink.asFlux();
  }

  public static OrderSink getOrderSinkInstance() {
    if (ORDER_SINK_INSTANCE == null) {
      ORDER_SINK_INSTANCE = new OrderSink();
    }
    return ORDER_SINK_INSTANCE;
  }

  public void publishOrderCompleteMessage(OrderCompleteDto orderCompleteDto) {
    this.sink.tryEmitNext(orderCompleteDto);
  }
}
