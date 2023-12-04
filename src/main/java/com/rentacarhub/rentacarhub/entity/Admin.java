package com.rentacarhub.rentacarhub.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;


@Entity
@Table(name = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableTransactionManagement
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phone;
    @Column(unique = true)
    private String email;

}
