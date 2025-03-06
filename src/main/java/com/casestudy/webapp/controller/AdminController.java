package com.casestudy.webapp.controller;

import com.casestudy.webapp.model.Customer;
import com.casestudy.webapp.model.Product;
import com.casestudy.webapp.service.CustomerService;
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
    @Autowired
    CustomerService customerService;

    @GetMapping("admin/admin")
    public String adminMainPage() {
        return "admin/admin";
    }

    @GetMapping("admin/customers")
    public String showCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "admin/customers";
    }

    @GetMapping("admin/products")
    public String productMainPage( Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin/products";
    }
}
