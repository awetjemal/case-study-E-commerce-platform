package com.casestudy.webapp.service;

import com.casestudy.webapp.model.Customer;
import com.casestudy.webapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Integer getLoggedInCustomerId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("Current auth.getName(): " + auth.getName()); // => returns username/email
        Customer customer = customerRepository.findByEmail(auth.getName());
        return customer.getId();
    }
}
