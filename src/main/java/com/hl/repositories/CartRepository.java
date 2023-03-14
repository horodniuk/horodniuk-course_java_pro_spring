package com.hl.repositories;


import com.hl.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Data
@AllArgsConstructor
public class CartRepository {
    private final Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) {
        Integer quantity = products.get(product);
        if (quantity == null) {
            quantity = 0;
        }
        products.put(product, quantity + 1);
    }

    public void removeProduct(Product product) {
        Integer quantity = products.get(product);
        if (quantity != null) {
            if (quantity == 1) {
                products.remove(product);
            } else {
                products.put(product, quantity - 1);
            }
        }
    }

}
