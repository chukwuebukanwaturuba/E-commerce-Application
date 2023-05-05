package com.example.week7updated.serviceImplementation;

import com.example.week7updated.dto.ProductDTO;
import com.example.week7updated.model.Product;
import com.example.week7updated.repository.ProductRepository;
import com.example.week7updated.repository.UsersRepository;
import com.example.week7updated.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private UsersRepository usersRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UsersRepository usersRepository) {
        this.productRepository = productRepository;
        this.usersRepository = usersRepository;
    }
@Override
    public Product addProduct(ProductDTO productDTO){
        Product product = new Product(productDTO);
    return productRepository.save(product);
    }



    @Override
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product findProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(()->new NullPointerException("Product with id "
                + productId+" does not exist"));
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean updatePrice(Long productID, BigDecimal price){
        Product product = findProduct(productID);
        if(product != null){
            product.setPrice(price);
            productRepository.save(product);
            return true;
        }
        return false;
    }
}
