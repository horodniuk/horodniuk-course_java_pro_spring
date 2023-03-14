package com.hl.repositories;


import com.hl.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRepository {
    private Map<Long, Product> storageCashe;

    public Product getProductById(Long productId) {
        return storageCashe.get(productId);
    }

    @PostConstruct
    public void init() {
        storageCashe = new HashMap<>();
        storageCashe.put(1L, new Product(1L, "beer", new BigDecimal(50)));
        storageCashe.put(2L, new Product(2L, "soap", new BigDecimal(20)));
        storageCashe.put(3L, new Product(3L, "cola", new BigDecimal(30)));
    }

}
