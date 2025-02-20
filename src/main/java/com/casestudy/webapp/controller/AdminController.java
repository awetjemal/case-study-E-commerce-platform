package com.casestudy.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("admin/admin")
    public String adminMainPage() {
        return "admin/admin";
    }
}
