package com.casestudy.webapp.combinedModels;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class CartBean {
    @Getter
    private Integer productId;
    private Integer quantity;
    private String productName;
    private String productImageUrl;
    private Double productPrice;

}
