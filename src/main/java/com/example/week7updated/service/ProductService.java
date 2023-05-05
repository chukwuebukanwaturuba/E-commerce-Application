package com.example.week7updated.service;

import com.example.week7updated.dto.ProductDTO;
import com.example.week7updated.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product addProduct(ProductDTO productDTO);

    List<Product> findAll();

    Product findProduct(Long productId);

    void deleteById(Long id);

    boolean updatePrice(Long productID, BigDecimal price);
}
