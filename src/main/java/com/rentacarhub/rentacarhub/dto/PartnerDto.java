package com.rentacarhub.rentacarhub.dto;

import com.rentacarhub.rentacarhub.entity.Partner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.beans.BeanProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String email;
    private String address;


    public static Partner getPartner(PartnerDto partnerDto){
        Partner partner = new Partner();
        BeanUtils.copyProperties(partnerDto,partner);
        return partner;
    }


    public static PartnerDto getPartnerDto(Partner partner){
        PartnerDto partnerDto = new PartnerDto();
        BeanUtils.copyProperties(partner,partnerDto);
        return partnerDto;
    }

}
