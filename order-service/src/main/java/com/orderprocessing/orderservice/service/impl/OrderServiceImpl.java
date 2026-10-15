package com.orderprocessing.orderservice.service.impl;

import com.orderprocessing.orderservice.kafka.event.OrderStatusChangedEvent;
import com.orderprocessing.orderservice.kafka.producer.OrderEventProducer;
import com.orderprocessing.orderservice.model.dto.OrderResponseStatusDto;
import com.orderprocessing.orderservice.model.dto.OrderUpdateStatusDto;
import com.orderprocessing.orderservice.model.entity.OrderEntity;
import com.orderprocessing.orderservice.model.repository.OrderRepository;
import com.orderprocessing.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author yefrosiniya.zinkovskaya
 * @since 19.09.2026
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderEventProducer orderEventProducer;

    @Override
    public OrderResponseStatusDto updateStatus(final Long id, final OrderUpdateStatusDto request) {
        if (Objects.isNull(request.getOrderStatus())) {
            throw new RuntimeException("Order status is null");
        }

        final OrderEntity order = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(request.getOrderStatus());
        orderRepository.save(order);

        orderEventProducer.sendOrderStatusEvent(new OrderStatusChangedEvent(
            id,
            request.getOrderStatus().toString()
        ));

        return OrderResponseStatusDto.builder()
            .orderStatus(request.getOrderStatus())
            .orderId(order.getId())
            .build();
    }
}
