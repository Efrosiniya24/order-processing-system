package com.orderprocessing.orderservice.kafka.producer;

import com.orderprocessing.orderservice.kafka.event.OrderStatusChangedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author yefrosiniya.zinkovskaya
 * @since 19.09.2026
 */
@Component
@RequiredArgsConstructor
public class OrderEventProducer {
    private static final String TOPIC = "order-events";
    private final KafkaTemplate<String, OrderStatusChangedEvent> kafkaTemplate;

    public void sendOrderStatusEvent(final OrderStatusChangedEvent orderStatusChangedEvent) {
        kafkaTemplate.send(
            TOPIC,
            orderStatusChangedEvent.orderId().toString(),
            orderStatusChangedEvent
        );
    }
}
