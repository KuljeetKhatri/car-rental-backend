package com.rentacarhub.rentacarhub.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.context.annotation.Lazy;
import org.thymeleaf.context.ILazyContextVariable;

import java.util.List;


@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    @Column(unique = true)
    private String email;
    private String phone;
    private String license_number;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations ;


// rental history one to many mapping
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<RentalHistory> rentalHistories;

    // one to one credit card mapping
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private CreditCard creditCard;

}
