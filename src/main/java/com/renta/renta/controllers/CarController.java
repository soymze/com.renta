package com.renta.renta.controllers;

import com.renta.renta.business.concretes.CarManager;
import com.renta.renta.business.dtos.responses.get.car.GetAllCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {

    private CarManager carManager;

    @GetMapping("getall")
    public List<GetAllCarResponse> getAll(@RequestParam("startDate")
                                              @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate startDate, @RequestParam("endDate")
    @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate endDate,
                                          @RequestParam(value = "brand", required = false) String brand,
                                          @RequestParam(value = "model", required = false) String model,
                                          @RequestParam(value = "year", required = false) Integer year,
                                          @RequestParam(value = "fuel", required = false) String fuel,
                                          Pageable pageable) {
        return carManager.search(startDate, endDate, brand, model, year, fuel, pageable);
    }
}
