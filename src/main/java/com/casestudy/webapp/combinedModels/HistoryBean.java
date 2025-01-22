package com.casestudy.webapp.combinedModels;

import lombok.Data;

@Data
public class HistoryBean {
    private Integer orderId;
    private String productName;
    private Integer quantityOrdered;
    private Double priceEach;
}
