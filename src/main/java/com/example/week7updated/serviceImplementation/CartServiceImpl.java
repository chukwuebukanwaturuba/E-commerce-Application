package com.example.week7updated.serviceImplementation;

import com.example.week7updated.dto.ProductDTO;
import com.example.week7updated.model.Cart;
import com.example.week7updated.model.Product;
import com.example.week7updated.repository.CartRepository;
import com.example.week7updated.repository.ProductRepository;
import com.example.week7updated.repository.UsersRepository;
import com.example.week7updated.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UsersRepository usersRepository;

    @Override
    public boolean addToCart(Long user_id, Long product_id){
        boolean status =false;
        List<Cart> existingCart = cartRepository.findCarts(user_id, product_id);
        if (!existingCart.isEmpty()) {
            Cart cart = existingCart.get(0);
            cart.setQty(cart.getQty() + 1);
            cartRepository.save(cart);
            status = true;
        } else {
            Cart cart = new Cart();
            cart.setProductid(product_id);
            cart.setUserid(user_id);
            cart.setQty(1);
            cartRepository.save(cart);
            status = true;
        }

        return status;
    }
    public List<ProductDTO> getProductById(Long id) {
        List<Cart> cart =  cartRepository.findByIdss(id);
        List<ProductDTO> list = new ArrayList<>();
        for(int i=0;i<cart.size();i++){
            System.out.println(cart.get(i).getProductid());
            System.out.println(cart.get(i).getUserid());
            Product productList = productRepository.findProductById(cart.get(i).getProductid());
            ProductDTO product = new ProductDTO();
            product.setId(productList.getId());
            product.setPrice(productList.getPrice());
            product.setProductName(productList.getProductName());
            product.setPhotoUrl(productList.getPhotoUrl());
            product.setCategory(productList.getCategory());
            product.setQty(productList.getQty());
            list.add(product);
        }
        System.out.println(list);


        return list;
    }
    @Override
    public List<Cart> getUserCart(Long user_id){return null;

    }

    @Override
    public void deleteCart(Long product_id, Long user_id){
        cartRepository.deleteCartByUseridAndProductid(product_id,user_id);
    }

    @Override
    public List<Product> displayUserCart(Long user_id) {
        List<Cart> cartList = getUserCart(user_id);
        List<Product> productList = new ArrayList<>();
        for(Cart cart: cartList){
            Product product = productRepository.findById(cart.getProductid()).orElse(null);
            if(product != null){
                productList.add(product);
            }
        }
        return productList;
    }

}
