package com.casestudy.webapp.repository;

import com.casestudy.webapp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByCustomerId(Integer customerId);

//    @Query(value = "SELECT * FROM users WHERE last_name = :lastName", nativeQuery = true)
//    List<User> findByLastName(String lastName);

    Cart deleteCartByCustomerIdAndProductId(Integer customerId, Integer productId);
}
