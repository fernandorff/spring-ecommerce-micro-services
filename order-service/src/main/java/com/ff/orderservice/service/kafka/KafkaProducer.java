package com.ff.orderservice.service.kafka;

import com.ff.orderservice.domain.dto.OrderCompleteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

  private final KafkaTemplate kafkaTemplate;

  public void sendOrderCompleteMessage(OrderCompleteDto orderCompleteDto) {
    kafkaTemplate.send("complete_orders", orderCompleteDto, orderCompleteDto);
  }
}
