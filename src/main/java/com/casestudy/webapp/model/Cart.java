package com.casestudy.webapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "cart")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Cart {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private Integer customerId;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Integer productId;

    @Column(name = "quantity")
    private Integer quantity;

}
