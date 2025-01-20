package com.casestudy.webapp.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@ToString
public class CartBean {
    private Integer productId;
    private Integer quantity;
}
