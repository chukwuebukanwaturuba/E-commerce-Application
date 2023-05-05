package com.example.week7updated.controller;

import com.example.week7updated.dto.ProductDTO;
import com.example.week7updated.dto.UserDTO;
import com.example.week7updated.model.UsersModel;
import com.example.week7updated.serviceImplementation.ProductServiceImpl;
import com.example.week7updated.serviceImplementation.UsersServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
    private final UsersServiceImpl usersService;
    private final ProductServiceImpl productService;

    public UsersController(UsersServiceImpl usersService, ProductServiceImpl productService) {

        this.usersService = usersService;
        this.productService = productService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute(value = "user") UserDTO userDTO) {
        System.out.println("register request: " + userDTO);
        try {
            UsersModel registeredUser = usersService.registerUser(userDTO);
            if (registeredUser != null) {
                return "redirect:/login";
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return "register";
    }


    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("products", new ProductDTO());
        model.addAttribute("productList",productService.findAll());
        return "admin";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new UsersModel());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel, Model model,HttpServletRequest req) {
//        System.out.println("login request: " + usersModel);

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(usersModel.getEmail());
        userDTO.setPassword(usersModel.getPassword());

        UsersModel authenticated = usersService.authenticate(userDTO);
        if (authenticated != null){

            if(userDTO.getEmail().equals("admin@email.com") && userDTO.getPassword().equals("1234")){
                return "redirect:/admin";
            }
            HttpSession session = req.getSession();
            session.setAttribute("id",authenticated.getId());


            return "redirect:/dashboard";
        } else {
            return "error_page";
        }
    }
@GetMapping("/dashboard")
public String dashboard(Model model,HttpSession session){
        Long id = (Long) session.getAttribute("id");
    model.addAttribute("id", id);
    model.addAttribute("list",productService.findAll());
    return "personal_page";
}
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        session.invalidate();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        modelAndView.addObject("user", new UserDTO());
        return modelAndView;
    }

}
