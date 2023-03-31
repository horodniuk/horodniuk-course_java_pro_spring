package org.example.store.service;


import org.example.store.dto.ProductDto;
import org.example.store.entity.Order;
import org.example.store.entity.Product;

import java.util.List;

public interface ProductServive {
     Product addOrUpdate(ProductDto order);
     List<Product> getAll();
     Product getById(Long id);
}
