package com.renta.renta.business.dtos.responses.get.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCarResponse {

    private int id;
    private String brand;
    private String model;
    private int year;
    private String fuel;
    private Double price;
    private String img_url;
}
