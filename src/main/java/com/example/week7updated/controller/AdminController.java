package com.example.week7updated.controller;

import com.example.week7updated.dto.ProductDTO;
import com.example.week7updated.serviceImplementation.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class AdminController {
    private  final ProductServiceImpl productService;

    public AdminController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public String addNewProduct(@ModelAttribute ProductDTO productDTO, Model model){
        productService.addProduct(productDTO);
        return "redirect:/admin";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id, Model model){
        productService.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/updatePrice")
    public String updateProductPrice(@RequestParam("id") Long id, @RequestParam("price") BigDecimal price, Model model){
        System.out.println(id);
        System.out.println(price);
        productService.updatePrice(id,price);
        return "redirect:/admin";
    }
}
