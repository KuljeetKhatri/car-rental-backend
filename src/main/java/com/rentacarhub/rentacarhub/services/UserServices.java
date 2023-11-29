package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.Reservation;
import com.rentacarhub.rentacarhub.entity.User;
import com.rentacarhub.rentacarhub.exception.ResourceNotFoundException;
import com.rentacarhub.rentacarhub.repository.ReservationRepository;
import com.rentacarhub.rentacarhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private ReservationRepository reservationRepository;

//    public void setUser(){
//
//        Date date = new Date();
//        LocalDateTime localDateTime = LocalDateTime.now();
//
//        Reservation reservation1 = new Reservation();
//        reservation1.setStatus("Active");
//        reservation1.setDate(localDateTime);
//
//        reservationRepository.save(reservation1);
//
//        Reservation reservation2 = new Reservation();
//        reservation2.setStatus("cancle");
//        reservation2.setDate(localDateTime);
//
//        reservationRepository.save(reservation2);
//
//
//        Reservation reservation3 = new Reservation();
//        reservation3.setStatus("Pending");
//        reservation3.setDate(localDateTime);
//
//        reservationRepository.save(reservation3);
//
//
//        User user = new User();
//        user.setUserName("Kuljeet Khatri");
//        user.setEmail("kkuljeet1265@nu.edu.pk");
//        user.setPassword("Khatri");
//        user.setFirstName("Kuljeet");
//        user.setLastName("Khatri");
//        user.setPhone("0332-3820423");
//
////        user.setReservations(List.of(reservation1,reservation2,reservation3));
//        userRepository.save(user);
//
//    }


//    public User findById(Long id){
//        return userRepository.findById(id).get();
//    }

    public User setUser(User user){
       return userRepository.save(user);
    }




    public List<User> getData(){
        return  userRepository.findAll();
    }

    public User findById(Long id) {
        return   userRepository.findById(id).orElse(null);
    }
    public User getUserEmail(String email){
        return userRepository.getUserByEmail(email);
    }
}
