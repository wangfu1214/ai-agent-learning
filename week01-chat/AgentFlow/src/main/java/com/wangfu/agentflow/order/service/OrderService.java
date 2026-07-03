package com.wangfu.agentflow.order.service;

import com.wangfu.agentflow.order.model.OrderInfo;
import com.wangfu.agentflow.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderInfo findById(String orderId){

        return orderRepository.findById(orderId);
    }
}
