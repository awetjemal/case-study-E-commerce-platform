package com.casestudy.webapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Entity
@Table(name = "customers")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String fistName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

//    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<Order> orders;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<History> histories;

//    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<Wishlist> wishlists;

}
