package com.casestudy.webapp.controller;

import com.casestudy.webapp.model.Product;
import com.casestudy.webapp.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
//@RequestMapping("/home")
public class IndexController {

    private final ProductService productService;

    public IndexController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("home/index")   // either type '/' or index
    public String showIndexPage(Model model)
    {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
//        for (Product p : products) {
//            System.out.println(p.getPrice() + " - " + p.getName() + " "+ p.getImageUrl() + " - " + p.getKeyWords());
//        }
        return "home/index";
    }

    @GetMapping("home/home")   // either type '/' or index
    public String showHomePage(Model model)
    {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
//        for (Product p : products) {
//            System.out.println(p.getPrice() + " - " + p.getName() + " "+ p.getImageUrl() + " - " + p.getKeyWords());
//        }
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("Current auth.getName(): " + auth.getName()); // => returns username/email
//        System.out.println("Current auth.getPrincipal(): " + auth.getPrincipal());
//        System.out.println("Current auth.getCredentials(): " + auth.getCredentials());
//        System.out.println("Current auth.getDetails(): " + auth.getDetails());


        return "home/home";
    }
    @GetMapping("home/wishlist")
    public String showWishlistPage(Model model){

        return "home/wishlist";
    }

    @GetMapping("home/cart")
    public String showCartPage(Model model){

        return "home/cart";
    }
}
