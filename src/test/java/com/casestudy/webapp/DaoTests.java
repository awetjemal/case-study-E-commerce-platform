package com.casestudy.webapp;

import com.casestudy.webapp.model.Cart;
import com.casestudy.webapp.repository.CartRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {

    @Autowired
    CartRepository cartRepository;

    @Test
    public void testCreateReadDeleteCart() {
        Cart cart = new Cart();
        cart.setCustomerId(1);
        cart.setProductId(2);
        cart.setQuantity(2);

        cartRepository.save(cart);

        Iterable<Cart> carts = cartRepository.findAll();
        Assertions.assertThat(carts).extracting(Cart::getCustomerId).containsOnly(1);

        cartRepository.deleteAll();
        Assertions.assertThat(cartRepository.findAll()).isEmpty();
    }
}
