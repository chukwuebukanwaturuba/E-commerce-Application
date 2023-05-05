package com.example.week7updated.repository;

import com.example.week7updated.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
//    List<Cart> findCartsByUser_id(Long id);
//
//    void deleteCartById(Long id);
    @Query(value = "SELECT * FROM cart where userid=?1 AND productid=?2",nativeQuery = true)

List<Cart> findCarts(Long Userid,Long productid);
    @Query(value = "SELECT * FROM cart where userid=?1",nativeQuery = true)

    List<Cart> findByIdss(Long id);
void deleteCartByUseridAndProductid(Long userid, Long productid);


}
