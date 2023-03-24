package com.hl.dao;

import com.hl.mappers.ProductMapper;
import com.hl.model.Cart;
import com.hl.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CartDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CartDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addProductToCart(Long cartId, Long productId) {
        String sql = "insert into carts_products(cart_id, product_id) values (?, ?)";
        jdbcTemplate.update(sql, cartId, productId);
    }

    public void deleteProductFromCart(Long cartId, Long productId) {
        String sql = "delete from carts_products where cart_id = ? AND product_id = ?";
        jdbcTemplate.update(sql, cartId, productId);
    }

    public Cart getById(Long id) {
        String sql = "select * from carts, carts_products" +
                     " where carts.id = carts_products.cart_id AND carts.id = ?";
        List<Product> products = jdbcTemplate.query(sql, new ProductMapper(), new Object[]{id});
        Cart cart = new Cart();
        cart.setProducts(products);
        return cart;
    }

    public void save(Cart cart) {
            jdbcTemplate.update("insert into carts (id) VALUES (?)", cart.getId());
    }
}
