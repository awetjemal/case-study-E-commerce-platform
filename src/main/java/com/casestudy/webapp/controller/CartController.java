package com.casestudy.webapp.controller;

import com.casestudy.webapp.combinedModels.CartBean;
import com.casestudy.webapp.model.Cart;
import com.casestudy.webapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;


    @PostMapping("/cart/addToCart")
    public ResponseEntity<Map<String, String>> addToCart(@RequestBody  CartBean cartBean) {
        // Logic to update database goes here
         Cart addedCart = cartService.addSingleItem(cartBean.getProductId(), cartBean.getQuantity());
         Integer totalQuantity = cartService.cartCount();
         boolean success =(addedCart != null);
        List<Double> cartTotals = cartService.getCartTotals(cartBean.getShippingOption());

         Map<String, String> response = new HashMap<>();
         if (success) {
             response.put("totalQuantity", "" + totalQuantity);
             response.put("totalLine1", "" + cartTotals.get(0));
             response.put("totalLine2", "" + cartTotals.get(1));
             response.put("totalLine3", "" + cartTotals.get(2));
             response.put("totalLine4", "" + cartTotals.get(3));
             response.put("totalLine5", "" + cartTotals.get(4));
             return ResponseEntity.ok(response);
         } else {
             response.put("message", "Update failed");
         } return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @PostMapping("/cart/removeFromCart")
    public ResponseEntity<Map<String, String>> removeFromCart(@RequestBody  CartBean cartBean) {
        // Logic to update database goes here

         cartService.removeSingleItem(cartBean.getProductId());
        Integer totalItemsInCart;
        Map<String, String> response = new HashMap<>();
        List<Double> cartTotals = cartService.getCartTotals(cartBean.getShippingOption());

        boolean success = (!cartService.isInCart(cartBean.getProductId()));

        if (success) {
            totalItemsInCart = cartService.cartCount();
            response.put("totalItemsInCart", "" + totalItemsInCart);
            response.put("totalLine1", "" + cartTotals.get(0));
            response.put("totalLine2", "" + cartTotals.get(1));
            response.put("totalLine3", "" + cartTotals.get(2));
            response.put("totalLine4", "" + cartTotals.get(3));
            response.put("totalLine5", "" + cartTotals.get(4));
            response.put("status", "removed");
            response.put("message", "Update Success");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Update failed to remove");
        } return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
