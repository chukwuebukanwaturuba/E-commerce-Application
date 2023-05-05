package com.example.week7updated.dto;

import com.example.week7updated.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String productName;
    private String category;
    private BigDecimal price;
    private String photoUrl;
    private Integer qty;

    public ProductDTO(Product product) {
        this.productName = product.getProductName();
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.photoUrl = product.getPhotoUrl();
        this.qty = product.getQty();
    }
}
