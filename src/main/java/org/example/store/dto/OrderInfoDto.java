package org.example.store.dto;

import lombok.Data;
import org.example.store.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderInfoDto {
    private Long id;
    private LocalDateTime date;
    private BigDecimal cost;
    private List<Product> products;
}
