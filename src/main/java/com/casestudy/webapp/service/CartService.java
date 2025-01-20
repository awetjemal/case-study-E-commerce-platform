package com.casestudy.webapp.service;

import com.casestudy.webapp.model.Cart;
import com.casestudy.webapp.model.Customer;
import com.casestudy.webapp.repository.CartRepository;
import com.casestudy.webapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerService customerService;


    //get the cart belonging to the current user logged in ie, current customer
    public List<Cart> getCartItems() {
        Integer customerId = customerService.getLoggedInCustomerId();
        //get list of cart entries for that customer
        return cartRepository.findByCustomerId(customerId);
    }
    //get total number of items sitting in the cart
    public Integer cartCount() {
        List<Cart> carts = getCartItems();
        Integer count = 0;
        for(Cart cart : carts) {
            count += cart.getQuantity();
        }
        return count;
    }
    //addSingleItem to cart or update its quantity if it is already in the cart
    public Cart addSingleItem(Integer productId, Integer quantity) {
       List<Cart> cartItems = getCartItems();
        List<Integer> productIds = new ArrayList<>();
        Cart existingCartItem = null;
        for (Cart cart : cartItems) {
            if(cart.getProductId() == productId){
                existingCartItem = cart;
                productIds.add(cart.getProductId());
            };
        }
        if (productIds.contains(productId)) {
            //update the quantity for that cartItem in the database
            existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
            return cartRepository.save(existingCartItem);
        }else {
            Cart cart = new Cart();
            cart.setCustomerId(customerService.getLoggedInCustomerId());
            cart.setProductId(productId);
            cart.setQuantity(quantity);
            return cartRepository.save(cart);
        }
    }

    //removeSingleItem from the cart after customer deleted the item from the cart
    // removeAllItem from the cart (one-by-one)and addToOrderDetail table along Order# after customer placed an order
    //getTotalItems in the cart for current user/customer

}
