package com.casestudy.webapp.controller;

import com.casestudy.webapp.config.CartBean;
import com.casestudy.webapp.model.Cart;
import com.casestudy.webapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

//    @GetMapping("cart/{productId}/{quantity}")
//        public String
//    @GetMapping("cart/addToCart")
//    public String addToCart() {
//
//        return "home/index";
//    }

    @PostMapping("/cart/addToCart")
    public ResponseEntity<Map<String, String>> addToCart(@RequestBody  CartBean cartBean) {
        // Logic to update database goes here
         Cart addedCart = cartService.addSingleItem(cartBean.getProductId(), cartBean.getQuantity());
         Integer totalQuantity = cartService.cartCount();
         boolean success =(addedCart != null);

         Map<String, String> response = new HashMap<>();
         if (success) {
             response.put("totalQuantity", "" + totalQuantity);
             return ResponseEntity.ok(response);
         } else {
             response.put("message", "Update failed");
         } return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
