package com.example.techtask.service.impl;

import com.example.techtask.model.Order;
import com.example.techtask.repository.OrderRepository;
import com.example.techtask.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.techtask.model.enumiration.UserStatus.ACTIVE;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order findOrder() {
        return orderRepository.findFirstByQuantityGreaterThanOrderByCreatedAtDesc(1);
    }

    @Override
    public List<Order> findOrders() {
        return orderRepository.findByUserStatusOrderByCreatedAt(ACTIVE);
    }
}
