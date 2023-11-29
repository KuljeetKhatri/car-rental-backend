package com.rentacarhub.rentacarhub.controller;

import com.rentacarhub.rentacarhub.dto.ReservationDto;
import com.rentacarhub.rentacarhub.dto.UserDto;
import com.rentacarhub.rentacarhub.entity.*;
import com.rentacarhub.rentacarhub.services.AdminServices;
import com.rentacarhub.rentacarhub.services.CarServices;
import com.rentacarhub.rentacarhub.services.ReservationServices;
import com.rentacarhub.rentacarhub.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationServices reservationServices;
    @Autowired
    private UserServices userServices;
    @Autowired
    private CarServices carServices;

//    @PostMapping("/{user_id}/{car_id}")
//    public ResponseEntity<?> setReservation(@PathVariable("user_id") Long user_id ,@PathVariable("car_id") Long car_id,
//                                            @RequestBody ReservationDto reservationDto) {
//        User user = userServices.findById(user_id);
//        Car car = carServices.findCarById(car_id);
//        if (user!=null) {
//            if(!car.getIsAvailable()){
//                return new ResponseEntity<>("Car is not available", HttpStatus.OK);
//            }
//            Reservation reservation = ReservationDto.getReservation(reservationDto);
//            reservation.setUser(user);
//            reservation.setCar(car);
//            reservation = reservationServices.set(reservation);
//            carServices.updateAvailable(car_id,false);
//            return new ResponseEntity<>(reservation, HttpStatus.OK);
//        }
//            return new ResponseEntity<>("First register  yourself", HttpStatus.OK);
//
//    }

    @PostMapping("/{user_id}/{car_id}")
    public ResponseEntity<?> setReservation(@PathVariable("user_id") Long user_id, @PathVariable("car_id") Long car_id, @RequestBody ReservationDto reservationDto) {
        User user = userServices.findById(user_id);
        if (user == null) {
            return new ResponseEntity<>("First register yourself", HttpStatus.OK);
        }
        Car car = carServices.findCarById(car_id);
        if (car == null) {
            // Handle the case where the car is not found
            return new ResponseEntity<>("Car not found", HttpStatus.OK);
        }
        if (!car.getIsAvailable()) {
            return new ResponseEntity<>("Car is not available", HttpStatus.OK);
        }
        Reservation reservation = ReservationDto.getReservation(reservationDto);
        reservation.setUser(user);
        reservation.setCar(car);
        Long day = RentCalculator.calculateRent(reservation);
        reservation.setRentPerDay(car.getRentPerDay()*day);
        reservation = reservationServices.set(reservation);
        carServices.updateAvailable(car_id, false);
        String message = "Reservation done";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<?> userReservation(@PathVariable("user_id") Long id){
        User user = userServices.findById(id);
        List<Reservation> reservationList = user.getReservations();
        List<ReservationDto> reservationDto = ReservationDto.getReservationDtoList(reservationList);
        return new ResponseEntity<>(reservationDto,HttpStatus.OK);

    }


    @GetMapping()
    public ResponseEntity<?> get(){
        return new ResponseEntity<>(reservationServices.findAll(),HttpStatus.OK);
    }


    @GetMapping("/totalrent")
    public ResponseEntity<?> totalRent(){
        Long rent = reservationServices.totalRent();
        return new ResponseEntity<>(rent,HttpStatus.OK);

    }


}
