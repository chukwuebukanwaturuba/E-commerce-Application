package com.example.week7updated.service;

import com.example.week7updated.model.Cart;
import com.example.week7updated.model.Product;

import java.util.List;

public interface CartService {
    boolean addToCart(Long user_id, Long product_id);

    List<Cart> getUserCart(Long user_id);

    void deleteCart(Long product_id, Long user_id);

    List<Product> displayUserCart(Long user_id);
}
