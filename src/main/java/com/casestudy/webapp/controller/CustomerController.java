package com.casestudy.webapp.controller;

import com.casestudy.webapp.combinedModels.CartBean;
import com.casestudy.webapp.model.Customer;
import com.casestudy.webapp.model.Order;
import com.casestudy.webapp.model.OrderDetail;
import com.casestudy.webapp.model.Product;
import com.casestudy.webapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

//    @Autowired
//    CustomerService customerService;

//    @GetMapping("admin/customers")
//    public String showCustomers(Model model) {
//        List<Customer> customers = customerService.getAllCustomers();
//        model.addAttribute("customers", customers);
//        System.out.println("customers list size is: " + customers.size());
//        return "admin/customers";
//    }

}
