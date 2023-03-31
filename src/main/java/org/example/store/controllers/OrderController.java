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


    @GetMapping
    private List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    private Order getById(@PathVariable Long id){
        return orderService.getById(id);
    }

    @PostMapping
    private OrderInfoDto add(@RequestBody OrderDto orderDto){
        return orderService.addOrUpdate(orderDto);
    }

}
