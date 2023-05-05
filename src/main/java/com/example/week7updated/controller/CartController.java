package com.example.week7updated.controller;

import com.example.week7updated.model.Cart;
import com.example.week7updated.serviceImplementation.CartServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartServiceImpl cartService;
    @GetMapping("/cart")
    public String addcart(Model model, HttpSession session){
        Long id = (Long) session.getAttribute("id");
        model.addAttribute("carts",cartService.getProductById(id));
        return "cart";
    }
    @PostMapping("/addCart")
    public ModelAndView addcarts(@RequestParam("userid") Long userid, @RequestParam("productid") Long productid,ModelAndView modelAndView){
       boolean cart= cartService.addToCart(userid,productid);
       if (cart){
           modelAndView.setViewName("redirect:/cart");
       }else{
           modelAndView.setViewName("redirect:/dashboard");
       }
       return  modelAndView;

    }
}
