package com.casestudy.webapp.formBeans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class NewProductBean {
    private String pName;
    private double pPrice;
    private String pKeyWords;
    private String pImageUrl;

}
