package com.casestudy.webapp.controller;

import com.casestudy.webapp.model.Product;
import com.casestudy.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    ProductService  productService;

    @GetMapping("admin/admin")
    public String adminMainPage() {
        return "admin/admin";
    }

    @GetMapping("admin/customers")
    public String customerMainPage() {
        return "admin/customers";
    }

    @GetMapping("admin/products")
    public String productMainPage( Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin/products";
    }
}
