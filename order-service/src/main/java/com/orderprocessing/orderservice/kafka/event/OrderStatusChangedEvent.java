package com.orderprocessing.orderservice.kafka.event;

/**
 * @author yefrosiniya.zinkovskaya
 * @since 19.09.2026
 */
public record OrderStatusChangedEvent(
    Long orderId,
    String status
) {
}
