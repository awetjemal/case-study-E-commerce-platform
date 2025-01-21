package com.casestudy.webapp.controller;

//import com.example.module309.form.SignupFormBean;
import com.casestudy.webapp.formBeans.LogInFormBean;
import com.casestudy.webapp.formBeans.SignupFormBean;
//import jakarta.validation.Valid;
import com.casestudy.webapp.model.Customer;
import com.casestudy.webapp.model.User;
import com.casestudy.webapp.repository.CustomerRepository;
import com.casestudy.webapp.repository.UserRepository;
import com.casestudy.webapp.security.AuthenticatedUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticatedUserService authenticatedUserService;

    // this get mapping is called by spring security when a secure resource is requested
    // needs to match the spring security configuration  .loginPage method
    @GetMapping("/login/login")
    public String theLoginPage(Model model) {
        model.addAttribute("loginForm", new LogInFormBean());
        System.out.println("called loginPage");

        return "login/loginForm";
    }
    @PostMapping("/login/login")
    public String theLoginPageSubmit(@Valid @ModelAttribute LogInFormBean user, BindingResult bindingResult,
                                     Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginForm", new LogInFormBean());
            return "login/loginForm";
        }
        else{
            //get user email & password , validate them
            User userInDatabase = userRepository.findByEmailIgnoreCase(user.getUsername());
            if(userInDatabase != null && passwordEncoder.matches(user.getPassword(), userInDatabase.getPassword()))
             {
                 authenticatedUserService.changeLoggedInUsername(session, user.getUsername(), user.getPassword());
                 return "redirect:/home/index";
             }
        }
            return "login/loginForm";
    }

    @GetMapping("/login/signUpForm")
    public String theSignupPage(Model model) {
        model.addAttribute("signUpForm", new SignupFormBean());

        return "login/signUpForm";
    }

    @PostMapping("/login/signUpForm")
    public String signupSubmit(@Valid @ModelAttribute SignupFormBean signupFormBean, BindingResult bindingResult , Model model) {
        model.addAttribute("signupFormBean", signupFormBean);
        //before adding a new customer to the database 1.confirm the two passwords are same 2. encrypt the password 3. validate email is unique
        if(bindingResult.hasErrors()) {
            return "login/signUpForm";
        }
        if(signupFormBean.getFirstPassword().equals(signupFormBean.getSecondPassword())) {
            String encryptedPassword = passwordEncoder.encode(signupFormBean.getSecondPassword());
            if(customerRepository.findAllEmails().contains(signupFormBean.getEmail())) {
                //display message that the email already exist ?
                return "redirect:/login/login";
            }
            Customer customer = new Customer();
            customer.setFistName(signupFormBean.getFirstName());
            customer.setLastName(signupFormBean.getLastName());
            customer.setEmail(signupFormBean.getEmail());
            customer.setPassword(encryptedPassword);
            customer.setPhoneNumber(signupFormBean.getPhone());
            customer.setStreet(signupFormBean.getStreet());
            customer.setCity(signupFormBean.getCity());
            customer.setState(signupFormBean.getState());
            customer.setZipCode(signupFormBean.getZipCode());
            customerRepository.save(customer);

            User user = new User();
            user.setEmail(signupFormBean.getEmail());
            user.setPassword(encryptedPassword);
            user.setName(signupFormBean.getFirstName());
            userRepository.save(user);
        }

        return "/login/loginForm";
    }
    @GetMapping("/login/logoutForm")
    public String displayLogoutPage(HttpSession session) {

        return "login/logoutForm";
    }


}
