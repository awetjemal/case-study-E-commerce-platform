package com.casestudy.webapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "name")
    private String name;

    @Column(name = "price", columnDefinition = "DECIMAL")
    private double price;

    @Column(name = "key_words")
    private String keyWords;

//    		public Product() {
//
//    		}
            public Product(String imageUrl, String name, double v, String s) {
                this.imageUrl = imageUrl;
                this.name = name;
                this.price = v;
                this.keyWords = s;
            }

//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<OrderDetail> orderDetails;



}
