package com.casestudy.webapp.service;

import com.casestudy.webapp.combinedModels.CartBean;
import com.casestudy.webapp.model.OrderDetail;
import com.casestudy.webapp.repository.OrderDetailsRepository;
import com.casestudy.webapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public OrderDetail addOrderDetail(Integer orderId, CartBean cartBean) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        orderDetail.setProductId(cartBean.getProductId());
        orderDetail.setQuantityOrdered(cartBean.getQuantity());
        orderDetail.setPriceEach(cartBean.getProductPrice());

        return orderDetailsRepository.save(orderDetail);

    }
//    public OrderDetail getAllOrderDetailSByCustomerId(Integer customerId) {
//        orderDetailsRepository.findAllByCustomerId;
//    }
}

