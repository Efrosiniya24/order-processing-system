package com.orderprocessing.notificationservice.kafka.consumer;

import com.orderprocessing.notificationservice.kafka.event.OrderStatusChangedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author yefrosiniya.zinkovskaya
 * @since 19.09.2026
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEventConsumer {
    private static final String TOPIC = "order-events";

    @KafkaListener(topics = TOPIC)
    public void getStatusEvent(final OrderStatusChangedEvent orderStatusChangedEvent) {
        log.info(
            "Received order event: orderId={}, status={}",
            orderStatusChangedEvent.orderId(),
            orderStatusChangedEvent.status()
        );
    }
}
