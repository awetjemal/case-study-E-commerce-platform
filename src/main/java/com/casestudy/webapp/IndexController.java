package com.casestudy.webapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
//@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")   // either type '/' or index
    public String showHomePage()
    {
        return "home";
    }
}
