package com.example.week7updated.model;

import com.example.week7updated.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "category")
    private String category;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "image")
    private String photoUrl;
    private Integer qty;


    public Product(ProductDTO productDTO) {
        this.productName = productDTO.getProductName();
        this.category = productDTO.getCategory();
        this.price = productDTO.getPrice();
        this.photoUrl = productDTO.getPhotoUrl();
    }

}
