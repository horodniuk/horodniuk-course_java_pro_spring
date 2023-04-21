package org.example.store.controllers;


import lombok.RequiredArgsConstructor;
import org.example.store.dto.ProductDto;
import org.example.store.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @GetMapping
    private List<ProductDto> getAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    private ProductDto getById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable Long id){
        productService.deleteProductById(id);
    }
}
