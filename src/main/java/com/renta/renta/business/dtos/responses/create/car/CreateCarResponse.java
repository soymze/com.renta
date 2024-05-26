package com.renta.renta.business.dtos.responses.create.car;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCarResponse {

    private int id;
    private String brand;
    private String model;
    private int year;
    private String fuel;
    private int price;
}