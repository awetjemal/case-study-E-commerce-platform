package com.casestudy.webapp.service;

import com.casestudy.webapp.combinedModels.CartBean;
import com.casestudy.webapp.combinedModels.HistoryBean;
import com.casestudy.webapp.model.Order;
import com.casestudy.webapp.model.OrderDetail;
import com.casestudy.webapp.repository.OrderDetailsRepository;
import com.casestudy.webapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    public OrderDetail addOrderDetail(Integer orderId, CartBean cartBean) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        orderDetail.setProductId(cartBean.getProductId());
        orderDetail.setQuantityOrdered(cartBean.getQuantity());
        orderDetail.setPriceEach(cartBean.getProductPrice());

        return orderDetailsRepository.save(orderDetail);

    }
    public List<OrderDetail> getAllOrderDetailSByOrderId(Integer orderId) {
        return orderDetailsRepository.findByOrderId(orderId);
    }
    public List<Order> getAllOrdersByCustomerId(Integer customerId) {
        return orderService.getAllOrdersByCustomerId(customerId);
    }
    public List<HistoryBean> getAllInHistoryForCurrentlyLoggedInUser() {
        Integer customerId = customerService.getLoggedInCustomerId();
        List<Order> orders = orderService.getAllOrdersByCustomerId(customerId);
        List<HistoryBean> historyBeans = new ArrayList<>();
        for (Order order : orders) {
            Integer orderId = order.getId();
            List<OrderDetail> orderDetails = orderDetailsRepository.findByOrderId(orderId);
            for (OrderDetail orderDetail : orderDetails) {
                HistoryBean historyBean = new HistoryBean();
                historyBean.setOrderId(orderId);
                historyBean.setProductName(productService.getProductById(orderDetail.getProductId()).getName());
                historyBean.setQuantityOrdered(orderDetail.getQuantityOrdered());
                historyBean.setPriceEach(orderDetail.getPriceEach());
                historyBeans.add(historyBean);

            }
        }
        return historyBeans;
    }
}

