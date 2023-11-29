package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.dto.CreditCardDto;
import com.rentacarhub.rentacarhub.entity.CreditCard;
import com.rentacarhub.rentacarhub.entity.User;
import com.rentacarhub.rentacarhub.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServices {

    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private UserServices userServices;
    public CreditCard addCreditCard(CreditCard creditCard){
        creditCardRepository.save(creditCard);
        return creditCard;
    }

}