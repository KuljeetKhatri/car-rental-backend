package com.rentacarhub.rentacarhub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "temp_car")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private String registrationNumber;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    @JsonIgnore
    private Partner partner;
}