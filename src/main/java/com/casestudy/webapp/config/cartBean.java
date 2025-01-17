package com.casestudy.webapp.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class cartBean {
    private List<Integer> ids = new ArrayList<>();
    private List<Integer> cartQuantities = new ArrayList<>();
}
