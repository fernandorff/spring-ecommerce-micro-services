package com.ff.orderservice.service.kafka;

import com.ff.orderservice.domain.dto.OrderCompleteDto;
import com.ff.orderservice.service.sink.OrderSink;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaOrderListener {

  private OrderSink orderSink = OrderSink.getOrderSinkInstance();

  @KafkaListener(topics = {
      "complete_orders"}, groupId = "order_1", containerFactory = "kafkaListenerContainerFactory")
  public void onListenOrderCompleteMessage(
      ConsumerRecord<OrderCompleteDto, OrderCompleteDto> consumerRecord) {
    var orderCompleteDto = consumerRecord.value();
    orderSink.publishOrderCompleteMessage(orderCompleteDto);
  }

}
