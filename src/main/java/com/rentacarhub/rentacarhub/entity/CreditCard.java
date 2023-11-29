package com.rentacarhub.rentacarhub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "credit_card")
    public class CreditCard {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        private Long cardNumber;
        private Integer month;
        private Integer year;
        private Integer cvv;


        @OneToOne
        @JoinColumn(name = "user_id")
        @JsonIgnore
        private User user;

        //One to many mapping payment info
        @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<PaymentInfo> paymentInfos;
    }
