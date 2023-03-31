package org.example.store.service;

import org.example.store.dto.OrderDto;
import org.example.store.dto.OrderInfoDto;
import org.example.store.entity.Order;

import java.util.List;


public interface OrderService {
    OrderInfoDto addOrUpdate(OrderDto order);
    List<Order> getAll();
    Order getById(Long id);
}
