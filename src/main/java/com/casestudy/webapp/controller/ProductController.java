package com.casestudy.webapp.controller;

import com.casestudy.webapp.model.Product;
import com.casestudy.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    //not properly functioning
    @GetMapping("product/productId")
    public String productId(Model model) {
        Product product = productService.getProductById(1);
        model.addAttribute("product", product);
        return "products";
    }
}
