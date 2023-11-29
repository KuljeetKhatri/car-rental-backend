package com.rentacarhub.rentacarhub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "car")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private String registrationNumber;
    private Boolean isAvailable;
    private Long rentPerDay;

    @OneToOne(mappedBy = "car")
    private Reservation reservation;
    // rental history one to many
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RentalHistory> rentalHistories;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    @JsonIgnore
    private Partner partner;




}
