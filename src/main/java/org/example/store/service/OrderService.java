package org.example.store.service;

import org.example.store.dto.OrderDto;
import org.example.store.dto.OrderInfoDto;
import org.example.store.entity.Order;

import java.util.List;


public interface OrderService {
    OrderInfoDto addOrder(OrderDto order);
    List<Order> getAllOrders();
    OrderInfoDto getOrderById(Long id);
    void deleteOrder(Long id);
}
