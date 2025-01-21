package com.casestudy.webapp.service;

import com.casestudy.webapp.model.Product;
import com.casestudy.webapp.model.Wishlist;
import com.casestudy.webapp.repository.CartRepository;
import com.casestudy.webapp.repository.WishlistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WishListService {
    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    //get all products in that customer's wishlist
    public List<Wishlist> getAllInWishlist(){
        Integer customerId = customerService.getLoggedInCustomerId();
        //get list of cart entries for that customer
        return wishlistRepository.findByCustomerId(customerId);
    }
    public List<Integer> getAllProductIdsInWishlist(){
        List<Integer> productIds = new ArrayList<>();
        List<Product> wishListedProducts = getAllProductsInWishlist();
        for(Product product : wishListedProducts){
            productIds.add(product.getId());
        }
        return productIds;
    }
    public List<Product> getAllProductsInWishlist(){
        List<Wishlist> wishlists = getAllInWishlist();
        List<Product> products = new ArrayList<>();
        for (Wishlist wishlist : wishlists) {
            products.add(productService.getProductById(wishlist.getProductId()));
        }
        return products;
    }
    //add the selected product to that customer's wishlist
    public Wishlist addToWishlist(Integer productId ){
        Integer customerId = customerService.getLoggedInCustomerId();
        Date date = new Date();
        Wishlist wishlist = new Wishlist();
        wishlist.setCustomerId(customerId);
        wishlist.setProductId(productId);
        wishlist.setDateAdded(date);
        return wishlistRepository.save(wishlist);
    }
    //remove the selected product from that customer's wishlist
    public void removeFromWishlist(Integer productId){
        Integer customerId = customerService.getLoggedInCustomerId();
       wishlistRepository.deleteByCustomerIdAndProductId(customerId, productId);
    }
    //count number products added to that customers wishlist
    public Integer wishlistCount(){
        return getAllInWishlist().size();
    }
    //check if the product is already in the wishlist
    public boolean isInWishlist(Integer productId){
        List<Wishlist> wishlists = getAllInWishlist();
        for(Wishlist wishlist : wishlists){
            if(wishlist.getProductId().equals(productId)){
                return true;
            }
        }
        return false;
    }
}
