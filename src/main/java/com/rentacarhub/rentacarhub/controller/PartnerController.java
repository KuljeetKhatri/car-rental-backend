package com.rentacarhub.rentacarhub.controller;

import com.rentacarhub.rentacarhub.dto.PartnerDto;
import com.rentacarhub.rentacarhub.entity.Partner;
import com.rentacarhub.rentacarhub.services.PartnerLoginServiceImpl;
import com.rentacarhub.rentacarhub.services.PartnerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/partner")
public class PartnerController {


    @Autowired
    private PartnerServices partnerServices;
    @Autowired
    PartnerLoginServiceImpl partnerLoginService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody PartnerDto partnerDto){
        Partner partner = PartnerDto.getPartner(partnerDto);
        partnerServices.savePartner(partner);
        partnerDto = PartnerDto.getPartnerDto(partner);
        return new ResponseEntity<>(partnerDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> get(){
        List<Partner> partners = partnerServices.getPartner();
        return new ResponseEntity<>(partners,HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<?> partnerLogin(@RequestBody Map<String, String> loginData) {
        boolean isAuthenticated = partnerLoginService.authenticatePartner(loginData.get("email"), loginData.get("password"));

        if (isAuthenticated) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        } else {
            // Handle other cases
            Map<String, String> response = new HashMap<>();
            response.put("error", "Login failed");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }





}
