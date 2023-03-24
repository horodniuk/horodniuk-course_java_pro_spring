package com.hl;

import com.hl.config.ProjectConfig;
import com.hl.dao.CartDao;
import com.hl.dao.ProductDao;
import com.hl.model.Cart;
import com.hl.model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            ProductDao productDao = context.getBean(ProductDao.class);
            CartDao cartDao = context.getBean(CartDao.class);

            Product beer = Product.builder()
                    .name("beer")
                    .price(new BigDecimal(50))
                    .build();

            Product soap = Product.builder()
                    .name("soap")
                    .price(new BigDecimal(20))
                    .build();

            Product cola = Product.builder()
                    .name("cola")
                    .price(new BigDecimal(30))
                    .build();

            productDao.save(beer);
            productDao.save(soap);
            productDao.save(cola);

     /*     productDao.delete(2L);

            Cart c1 = Cart.builder()
                    .id(1L)
                    .build();

            cartDao.save(c1);
            cartDao.addProductToCart(c1.getId(), productDao.getById(1L).getId());
            cartDao.addProductToCart(c1.getId(), productDao.getById(3L).getId());

            Cart c2 = Cart.builder()
                    .id(2L)
                    .build();
            cartDao.save(c2);
            cartDao.addProductToCart(c2.getId(), productDao.getById(3L).getId());
            cartDao.deleteProductFromCart(c1.getId(), productDao.getById(1L).getId());*/
        }
    }
}
