package com.orderprocessing.orderservice.service;

import com.orderprocessing.orderservice.model.dto.OrderResponseStatusDto;
import com.orderprocessing.orderservice.model.dto.OrderUpdateStatusDto;

/**
 * @author yefrosiniya.zinkovskaya
 * @since 19.09.2026
 */
public interface OrderService {
    OrderResponseStatusDto updateStatus(Long id, OrderUpdateStatusDto request);
}
