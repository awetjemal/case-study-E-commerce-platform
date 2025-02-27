package com.casestudy.webapp.repository;

import com.casestudy.webapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {


    List<Order> findAllByCustomerId(Integer customerId);

    List<Integer> findAllOrderIdsByCustomerId(Integer customerId);
}
