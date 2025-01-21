package com.casestudy.webapp.repository;

import com.casestudy.webapp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByCustomerId(Integer customerId);

//    @Query(value = "SELECT * FROM users WHERE last_name = :lastName", nativeQuery = true)
//    List<User> findByLastName(String lastName);

    @Modifying
    @Query(value = "delete from cart where product_id = :productId and customer_id = :customerId", nativeQuery = true)
    void deleteCartByCustomerIdAndProductId(Integer customerId, Integer productId);
}
