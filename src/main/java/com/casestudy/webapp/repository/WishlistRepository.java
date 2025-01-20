package com.casestudy.webapp.repository;

import com.casestudy.webapp.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    List<Wishlist> findByCustomerId(Integer customerId);
    @Modifying
    @Query(value = "delete from wishlist where product_id = :productId and customer_id = :customerId", nativeQuery = true)
   void deleteByCustomerIdAndProductId(Integer customerId, Integer productId);

    //    @Query(value = "SELECT * FROM users WHERE last_name = :lastName", nativeQuery = true)
//    List<User> findByLastName(String lastName);
}
