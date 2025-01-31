package com.casestudy.webapp;

import com.casestudy.webapp.controller.IndexController;
import com.casestudy.webapp.model.Product;
import com.casestudy.webapp.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class WebappApplicationTests {

    @Autowired
    IndexController indexController;

    @Test
    public void contextLoads() {
        Assertions.assertThat(indexController).isNotNull();
    }
}
