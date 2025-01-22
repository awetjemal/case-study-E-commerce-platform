package com.casestudy.webapp.controller;

import com.casestudy.webapp.combinedModels.CartBean;
import com.casestudy.webapp.model.Cart;
import com.casestudy.webapp.model.Order;
import com.casestudy.webapp.model.OrderDetail;
import com.casestudy.webapp.model.Product;
import com.casestudy.webapp.repository.CustomerRepository;
import com.casestudy.webapp.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
//@RequestMapping("/home")
public class IndexController {

    private final ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private WishListService wishListService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;


    public IndexController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("home/index")   // either type '/' or index
    public String showIndexPage(Model model)
    {
        List<Product> products = productService.getAllProducts();
        Integer cartCount = cartService.cartCount();
        List<Integer> wishListedProducts = wishListService.getAllProductIdsInWishlist();
        model.addAttribute("cartCount", cartCount);
        model.addAttribute("products", products);
        model.addAttribute("wishListedProducts", wishListedProducts);

//        for (Product p : products) {
//            System.out.println(p.getPrice() + " - " + p.getName() + " "+ p.getImageUrl() + " - " + p.getKeyWords());
//        }
        return "home/index";
    }

    @GetMapping("home/history")   // either type '/' or index
    public String showHomePage(Model model) {

        Integer cartCount = cartService.cartCount();
        model.addAttribute("cartCount", cartCount);
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        List<Cart> cartItems = cartService.getCartItems();
        model.addAttribute("cartItems", cartItems);
        List<Product> wishListedProducts = wishListService.getAllProductsInWishlist();
        model.addAttribute("wishListedProducts", wishListedProducts);

        return "home/history";
    }
    @GetMapping("home/wishlist")
    public String showWishlistPage(Model model){
        List<Product> wishListedProducts = wishListService.getAllProductsInWishlist();
        Integer cartCount = cartService.cartCount();
        model.addAttribute("cartCount", cartCount);
        model.addAttribute("wishListedProducts", wishListedProducts);

        return "home/wishlist";
    }

    @GetMapping("home/cart")
    public String showCartPage(Model model){
        List<CartBean> cartBeans = cartService.getCartBeansInCart();
        List<Product> wishListedProducts = wishListService.getAllProductsInWishlist();
        List<Double> cartTotals = cartService.getCartTotals("Option1");
        Integer cartCount = cartService.cartCount();
        model.addAttribute("cartBeans", cartBeans);
        model.addAttribute("cartCount", cartCount);
        model.addAttribute("wishListedProducts", wishListedProducts);
        model.addAttribute("cartTotals", cartTotals);

        return "home/cart";
    }
    @GetMapping("home/placedOrder")
    public String placedOrder(Model model) {
        Integer customerId = customerService.getLoggedInCustomerId();
        List<CartBean> cartBeans = cartService.getCartBeansInCart();
        String message = "Order Placed Successfully, Thank you";
        model.addAttribute("message", message);
        //place order for the customer
        Order order = orderService.addOrder(customerId);
        Integer orderId = order.getId();
        //add every item in the cart to the order-detail table and remove it from the cart
        for (CartBean cartBean : cartBeans) {
            OrderDetail addedOrderItem = orderDetailService.addOrderDetail(orderId, cartBean);
            if (addedOrderItem != null) {
                cartService.removeSingleItem(cartBean.getProductId());
            }
        }
        cartBeans = cartService.getCartBeansInCart();
        List<Product> wishListedProducts = wishListService.getAllProductsInWishlist();
        List<Double> cartTotals = cartService.getCartTotals("Option1");
        Integer cartCount = cartService.cartCount();
        model.addAttribute("cartBeans", cartBeans);
        model.addAttribute("cartCount", cartCount);
        model.addAttribute("wishListedProducts", wishListedProducts);
        model.addAttribute("cartTotals", cartTotals);

        return "home/cart";
    }
}
