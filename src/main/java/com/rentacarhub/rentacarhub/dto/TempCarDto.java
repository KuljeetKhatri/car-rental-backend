package com.rentacarhub.rentacarhub.dto;

import com.rentacarhub.rentacarhub.entity.Car;
import com.rentacarhub.rentacarhub.entity.TempCar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempCarDto {
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private String registrationNumber;



    public static TempCar getTempCar(TempCarDto tempCarDto){
        TempCar tempCar = new TempCar();
        BeanUtils.copyProperties(tempCarDto,tempCar);
        return tempCar;
    }

    public static TempCarDto getTempCarDto(TempCar tempCar){
        TempCarDto tempCarDto = new TempCarDto();
        BeanUtils.copyProperties(tempCar,tempCarDto);
        return tempCarDto;
    }

    public static List<TempCarDto> getTempCarDtos(List<TempCar> tempCar){
        List<TempCarDto> tempCarDto = new ArrayList<>();
        BeanUtils.copyProperties(tempCar,tempCarDto);
        return tempCarDto;
    }


}
