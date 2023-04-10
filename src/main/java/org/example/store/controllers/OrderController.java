package org.example.store.controllers;


import lombok.RequiredArgsConstructor;
import org.example.store.dto.OrderDto;
import org.example.store.dto.OrderInfoDto;
import org.example.store.entity.Order;
import org.example.store.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public OrderInfoDto createOrder(@RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }

    @GetMapping
    private List<Order> getAll(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    private OrderInfoDto getById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}
