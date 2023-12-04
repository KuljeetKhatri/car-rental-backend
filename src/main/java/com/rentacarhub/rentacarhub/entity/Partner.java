package com.rentacarhub.rentacarhub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableTransactionManagement
@Table(name = "partner")
    public class Partner {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        private String firstName;
        private String lastName;
        private String password;
        private String phone;
        @Column(unique = true)
        private String email;
        private String address;


        @OneToMany(mappedBy = "partner",cascade = CascadeType.ALL)
        private List<Car> cars;

        @OneToMany(mappedBy = "partner",cascade = CascadeType.ALL)
        private List<TempCar> tempCars;

    }
