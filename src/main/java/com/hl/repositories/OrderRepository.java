package com.hl.repositories;


import com.hl.model.Order;
import com.hl.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Data
@AllArgsConstructor
public class OrderRepository {
    private final Map<Long, Order> products = new HashMap<>();

    public void addOrder(Order order) {
        products.put(order.getId(), order);
    }

    Order getOrderById(Long orderId){
       return products.get(orderId);
    }

    @PostConstruct
    public void init() {
        Product beer = new Product(1L, "beer", new BigDecimal(50));
        Product soap = new Product(2L, "soap", new BigDecimal(20));
        Product cola = new Product(3L, "beer", new BigDecimal(30));

        Map<Product, Integer> productsByOrder1 = new HashMap<>() {{
            put(beer, 2); // cost by order1  50 * 2 = 100
        }};

        Map<Product, Integer> productsByOrder2 = new HashMap<>() {{
            put(soap, 1);
            put(cola, 2); // cost by order2  20 * 30 = 50
        }};

        Order order1 = new Order(1L, LocalDateTime.now(), new BigDecimal(100), productsByOrder1);
        Order order2 = new Order(2L, LocalDateTime.now(), new BigDecimal(100), productsByOrder1);
    }

}
