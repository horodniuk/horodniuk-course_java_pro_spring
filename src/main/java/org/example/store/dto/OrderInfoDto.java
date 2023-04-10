package org.example.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoDto {
    private Long id;
    private LocalDateTime date;
    private BigDecimal cost;
    private Map<ProductDto, Integer> products;
}
