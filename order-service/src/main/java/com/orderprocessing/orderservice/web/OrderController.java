package com.orderprocessing.orderservice.web;

import com.orderprocessing.orderservice.model.dto.OrderResponseStatusDto;
import com.orderprocessing.orderservice.model.dto.OrderUpdateStatusDto;
import com.orderprocessing.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yefrosiniya.zinkovskaya
 * @since 19.09.2026
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PutMapping("/{id}/status")
    public ResponseEntity<OrderResponseStatusDto> updateOrder(
        final @PathVariable Long id,
        final @RequestBody OrderUpdateStatusDto request
    ) {
        return ResponseEntity.ok(orderService.updateStatus(id, request));
    }

}
