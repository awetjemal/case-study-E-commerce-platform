package com.casestudy.webapp;

import com.casestudy.webapp.model.Product;
import com.casestudy.webapp.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/home")
public class IndexController {

    private final ProductService productService;

    public IndexController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")   // either type '/' or index
    public String showIndexPage(Model model)
    {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
//        for (Product p : products) {
//            System.out.println(p.getPrice() + " - " + p.getName() + " "+ p.getImageUrl() + " - " + p.getKeyWords());
//        }
        return "index";
    }

    @GetMapping("/Home")   // either type '/' or index
    public String showHomePage(Model model)
    {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
//        for (Product p : products) {
//            System.out.println(p.getPrice() + " - " + p.getName() + " "+ p.getImageUrl() + " - " + p.getKeyWords());
//        }
        return "home";
    }
    @GetMapping("/wishlist")
    public String showWishlistPage(Model model){

        return "wishlist";
    }

    @GetMapping("/cart")
    public String showCartPage(Model model){

        return "cart";
    }
}
