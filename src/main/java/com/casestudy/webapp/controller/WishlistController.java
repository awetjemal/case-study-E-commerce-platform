package com.casestudy.webapp.controller;

import com.casestudy.webapp.formBeans.WishlistBean;
import com.casestudy.webapp.model.Wishlist;
import com.casestudy.webapp.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WishlistController {
    @Autowired
    private WishListService wishListService;

    @PostMapping("/wishlist/updateWishlist")
    public ResponseEntity<Map<String, String>> addOrRemoveToWishlist(@RequestBody WishlistBean wishlistBean) {
        // Logic to update database goes here
        Integer productId = wishlistBean.getProductId();
        Integer totalInWishlist ;
        Map<String, String> response = new HashMap<>();
        if(!wishListService.isInWishlist(productId)){
            Wishlist wishlist = wishListService.addToWishlist(productId);
            totalInWishlist = wishListService.wishlistCount();
            boolean success =(wishlist != null && totalInWishlist > 0);
            if (success) {
                response.put("totalInWishlist", "" + totalInWishlist);
                response.put("status", "added");
                response.put("message", "Update Success");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Update failed to add");
            }

        }else {
            //In Spring Data JPA, the deleteById method in the CrudRepository interface
            // (which is typically extended by your Spring Data repositories) has a void return type.
            wishListService.removeFromWishlist(productId);
            if(!wishListService.isInWishlist(productId)){
                totalInWishlist = wishListService.wishlistCount();
                response.put("totalInWishlist", "" + totalInWishlist);
                response.put("status", "removed");
                response.put("message", "Update Success");
                return ResponseEntity.ok(response);
            }else {
                response.put("message", "Update failed to remove");
            }

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

    }
    @PostMapping("/wishlist/removeFromWishlist")
    public ResponseEntity<Map<String, String>> removeFromWishlist(@RequestBody WishlistBean wishlistBean){
        Integer productId = wishlistBean.getProductId();
        Integer totalInWishlist ;
        Map<String, String> response = new HashMap<>();
        wishListService.removeFromWishlist(productId);
        if(!wishListService.isInWishlist(productId)){
            totalInWishlist = wishListService.wishlistCount();
            response.put("totalInWishlist", "" + totalInWishlist);
            response.put("status", "removed");
            response.put("message", "Update Success");
            return ResponseEntity.ok(response);
        }else {
            response.put("message", "Update failed to remove");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

    }


}
