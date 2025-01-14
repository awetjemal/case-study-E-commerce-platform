package com.casestudy.webapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;


@Entity
@Table(name = "wishlist")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Wishlist {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Integer productId;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private Integer customerId;

    @Column(name = "date_added",  columnDefinition = "DATE")
    private Date dateAdded;

}
