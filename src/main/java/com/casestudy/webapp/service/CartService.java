package com.casestudy.webapp.service;

import com.casestudy.webapp.combinedModels.CartBean;
import com.casestudy.webapp.model.Cart;
import com.casestudy.webapp.model.Customer;
import com.casestudy.webapp.model.Product;
import com.casestudy.webapp.repository.CartRepository;
import com.casestudy.webapp.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    //get the cart belonging to the current user logged in ie, current customer
    public List<Cart> getCartItems() {
        Integer customerId = customerService.getLoggedInCustomerId();
        //get list of cart entries for that customer
        return cartRepository.findByCustomerId(customerId);
    }
    //get all products-detail currently sitting in the cart.
    public List<Product> getAllProductsInCart() {
        List<Cart> carts = getCartItems();
        List<Product> products = new ArrayList<>();
        for (Cart cart : carts) {
            products.add(productService.getProductById(cart.getProductId()));
        }
        return products;
    }
    //get and return CartBean collections to be passed to the cart page
    public List<CartBean> getCartBeansInCart() {
        List<Cart> carts = getCartItems();
        List<Product> products = getAllProductsInCart();
        List<CartBean> cartBeans = new ArrayList<>();
        for(int i = 0; i < carts.size(); i++) {
            CartBean cartBean = new CartBean();
            cartBean.setProductId(carts.get(i).getProductId());
            cartBean.setQuantity(carts.get(i).getQuantity());
            cartBean.setProductName(products.get(i).getName());
            cartBean.setProductPrice(products.get(i).getPrice());
            cartBean.setProductImageUrl(products.get(i).getImageUrl());
            cartBeans.add(cartBean);
        }
        return cartBeans;
    }
    //calculate and return total value in cart before tax
    public List<Double> getCartTotals(String shippingOption) {
        List<Double> cartTotals = new ArrayList<>();
        double totalBeforeShippingAndTax = 0.0;
        List<CartBean> cartBeans = getCartBeansInCart();
        for(CartBean cartBean : cartBeans) {
            totalBeforeShippingAndTax += (cartBean.getProductPrice() * cartBean.getQuantity());
        }
//         double roundedNumber = Math.round(number * 100.0) / 100.0;
        cartTotals.add(Math.round(totalBeforeShippingAndTax * 100.0) / 100.0);

        double shippingFee = 0.0;
        if(cartCount() == 0){
            shippingFee = 0.00;
        }else if(shippingOption.equals("Option1")) {
            shippingFee = 4.99;
        }else if(shippingOption.equals("Option2")) {
            shippingFee = 9.99;
        }else if(shippingOption.equals("Option0")) {
            shippingFee = 0.00;
        }

        cartTotals.add(shippingFee);
        double totalBeforeTax = shippingFee + totalBeforeShippingAndTax;
        cartTotals.add(Math.round(totalBeforeTax * 100.0) / 100.0);

        double estimatedTax = 0.10 * totalBeforeTax;
        cartTotals.add(Math.round( estimatedTax * 100.0) / 100.0);

        double orderTotal = estimatedTax + totalBeforeTax;
        cartTotals.add(Math.round(orderTotal * 100.0) / 100.0);

        return cartTotals;
    }
    //get total count of items sitting in the cart
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
    public void removeSingleItem(Integer productId) {
        Integer customerId = customerService.getLoggedInCustomerId();
        cartRepository.deleteCartByCustomerIdAndProductId(customerId, productId);
    }
    public boolean isInCart(Integer productId) {
        List<Cart> cartItems = getCartItems();
        for (Cart cart : cartItems) {
            if(cart.getProductId() == productId){
                return true;
            }
        }
        return false;
    }
    // removeAllItem from the cart (one-by-one)and addToOrderDetail table along Order# after customer placed an order
    //getTotalItems in the cart for current user/customer

}
