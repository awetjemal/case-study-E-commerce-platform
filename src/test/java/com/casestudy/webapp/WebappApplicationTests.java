package com.casestudy.webapp;

import com.casestudy.webapp.model.Product;
import com.casestudy.webapp.repository.ProductRepository;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class WebappApplicationTests {
	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(productRepository);
	}

	@Test
	public void testCreateReadDelete() {
		Product product = new Product("imageUrl", "pName", 99.99, "keywords");

		productRepository.save(product);

//		Iterable<Product> employees = productRepository.findAll();
//		Assertions.assertThat(employees).extracting(Product::getImageUrl).containsOnly("imageUrl");

		Assertions.assertEquals(product.getImageUrl(), "imageUrl");

		productRepository.deleteById(product.getId());
        Assertions.assertNull(productRepository.findById(product.getId()));
	}

}
