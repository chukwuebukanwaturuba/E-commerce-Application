package com.example.week7updated.model;

import com.example.week7updated.dto.CartDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="productid")
    private Long productid;
    @Column(name = "userid")
    private Long userid;
    private Integer qty;
    public Cart(CartDTO cartDTO){
        this.productid = cartDTO.getProduct_id();
        this.userid = cartDTO.getUser_id();
        this.qty = cartDTO.getQty();
    }
}
