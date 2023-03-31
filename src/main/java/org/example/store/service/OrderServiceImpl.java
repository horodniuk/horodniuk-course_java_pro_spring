package org.example.store.service;

import lombok.RequiredArgsConstructor;
import org.example.store.dto.OrderDto;
import org.example.store.dto.OrderInfoDto;
import org.example.store.entity.Order;
import org.example.store.entity.Product;
import org.example.store.repositories.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
        public OrderInfoDto addOrUpdate(OrderDto orderDto) {
            Order order = modelMapper.map(orderDto, Order.class);
            order.setOrderDate(LocalDateTime.now());
            order.setCost(calculateCost(order.getOrderProducts()));
            Order tempOrder = orderRepository.save(order);
            return modelMapper.map(tempOrder, OrderInfoDto.class);
    }



    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).get();
    }

    private BigDecimal calculateCost(List<Product> orderProducts) {
        BigDecimal cost = BigDecimal.ZERO;
        for (Product product : orderProducts) {
            cost = cost.add(product.getPrice());
        }
        return cost;
    }
}
