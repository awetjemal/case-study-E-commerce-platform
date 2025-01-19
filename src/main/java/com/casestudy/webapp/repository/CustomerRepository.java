package com.casestudy.webapp.repository;

import com.casestudy.webapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT u.email FROM User u")
    List<String> findAllEmails();
//        List<String> findAllCustomerEmails();
    Customer findByEmail(String email);
}
