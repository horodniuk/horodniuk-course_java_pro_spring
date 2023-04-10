package org.example.store.service;

import lombok.RequiredArgsConstructor;
import org.example.store.dto.OrderDto;
import org.example.store.dto.OrderInfoDto;
import org.example.store.dto.ProductDto;
import org.example.store.entity.Order;
import org.example.store.entity.Product;
import org.example.store.repositories.OrderRepository;
import org.example.store.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    @Override
    public OrderInfoDto addOrder(OrderDto OrderDto) {
        Order order = new Order();
        Map<Product, Integer> products = getProductMap(OrderDto);
        order.setProducts(products);
        order.setOrderDate(LocalDateTime.now());
        order.setCost(calculateOrderCost(order, products));
        Order tempOrder = orderRepository.save(order);
        OrderInfoDto orderInfoDto = modelMapper.map(tempOrder, OrderInfoDto.class);
        return orderInfoDto;

    }

    private Map<Product, Integer> getProductMap(OrderDto orderDto) {
        Map<Product, Integer> products = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : orderDto.getProducts().entrySet()) {
            Optional<Product> product = productRepository.findById(entry.getKey());
            if (product.isEmpty()) {
                throw new IllegalArgumentException("Product Id " + entry.getKey() + "not exist");
            }
            products.put(product.get(), entry.getValue());
        }
        return products;
    }

    private BigDecimal calculateOrderCost(Order order, Map<Product, Integer> productMap) {
        BigDecimal totalCost = BigDecimal.ZERO;
        Map<Long, Integer> products = convertProductMap(productMap);
        for (Long productId : products.keySet()) {
            Integer quantity = products.get(productId);
            Product product = productRepository.findById(productId).orElse(null);
            if (product != null) {
                BigDecimal price = product.getPrice();
                BigDecimal productCost = price.multiply(BigDecimal.valueOf(quantity));
                totalCost = totalCost.add(productCost);
            }
        }
        return totalCost;
    }

    private Map<Long, Integer> convertProductMap(Map<Product, Integer> productMap) {
        Map<Long, Integer> convertIdMap = new HashMap<>();
        for (Product product : productMap.keySet()) {
            if (product != null) {
                convertIdMap.put(product.getProductId(), productMap.get(product));
            }
        }
        return convertIdMap;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    @Override
    public OrderInfoDto getOrderById(Long id) {
        Order tempOrder = orderRepository.findById(id).orElse(null);
        OrderInfoDto orderInfoDto = modelMapper.map(tempOrder, OrderInfoDto.class);
        return orderInfoDto;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
