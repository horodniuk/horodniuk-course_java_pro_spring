package com.hl.model;

import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}

