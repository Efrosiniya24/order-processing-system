package com.orderprocessing.orderservice.model.dto;

import com.orderprocessing.orderservice.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yefrosiniya.zinkovskaya
 * @since 19.09.2026
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderUpdateStatusDto {
    private OrderStatus orderStatus;
}
