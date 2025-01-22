package com.casestudy.webapp.service;

import com.casestudy.webapp.model.Order;
import com.casestudy.webapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public Order addOrder(Integer customerId) {
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setOrderDate(new Date());
        order.setRequiredDate(null);
        order.setShippedStatus("Not Shipped");
        order.setShippedDate(null);
        return orderRepository.save(order);

    }
    public List<Order> getAllOrdersByCustomerId(Integer customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }

    public List<Integer> getAllOrderIdsByCustomerId(Integer customerId) {
        return orderRepository.findAllOrderIdsByCustomerId(customerId);
    }
}
