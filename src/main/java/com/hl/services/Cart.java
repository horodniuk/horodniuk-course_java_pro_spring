package com.hl.services;

import com.hl.model.Product;
import com.hl.repositories.CartRepository;
import com.hl.repositories.ProductRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Scope(value = "prototype")
public class Cart {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public Cart(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public void addProductToCartById(Long productId) {
        Product product = productRepository.getProductById(productId);
        if (product != null) {
            cartRepository.addProduct(product);
            System.out.println(product + " added to cart");
        }
    }

    public void removeProductFromCartById(Long productId) {
        Product product = productRepository.getProductById(productId);
        if (product != null) {
            cartRepository.removeProduct(product);
            System.out.println(product + " removed from cart");
        }
    }

    public Map<Product, Integer> getProductsInCart() {
        return cartRepository.getProducts();
    }
}
