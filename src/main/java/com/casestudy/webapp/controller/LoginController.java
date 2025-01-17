package com.casestudy.webapp.controller;

//import com.example.module309.form.SignupFormBean;
import com.casestudy.webapp.config.Greeting;
import com.casestudy.webapp.config.SignupFormBean;
//import jakarta.validation.Valid;
import com.casestudy.webapp.config.SignupFormClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {


    // this get mapping is called by spring security when a secure resource is requested
    // needs to match the spring security configuration  .loginPage method
    @GetMapping("/login/login")
    public ModelAndView theLoginPage() {
        ModelAndView response = new ModelAndView();
        System.out.println("called loginPage");
//        response.setViewName("login/loginPage");
        response.setViewName("login/loginForm");
        return response;
    }

    @GetMapping("/login/signUpForm")
    public String theSignupPage(Model model) {
        model.addAttribute("signUpForm", new SignupFormClass());

        return "login/signUpForm";
    }

    @PostMapping("/login/signUpForm")
    public String signupSubmit(@ModelAttribute SignupFormBean signupFormBean, Model model) {
        model.addAttribute("signupFormBean", signupFormBean);

//        System.out.println(signupFormBean.getFirstName() + " " + signupFormBean.getLastName() + " " + signupFormBean.getEmail());

        return "/login/loginForm";
    }
    @GetMapping("/login/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }
    @PostMapping("/login/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }
}
