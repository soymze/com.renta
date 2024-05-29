package com.renta.renta.controllers;

import com.renta.renta.business.abstracts.CarService;
import com.renta.renta.business.concretes.CarManager;
import com.renta.renta.business.dtos.responses.get.car.GetAllCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController extends BaseController{

    private CarManager carManager;
    private CarService carService;
    @GetMapping("getall")
    public List<GetAllCarResponse> getAll(@RequestParam("startDate")
                                              @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate startDate, @RequestParam("endDate")
    @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate endDate,
                                          @RequestParam(value = "brand", required = false) String brand,
                                          @RequestParam(value = "type", required = false) String type,
                                          @RequestParam(value = "year", required = false) Integer year,
                                          @RequestParam(value = "fuel", required = false) String fuel,
                                          Pageable pageable) {
        return carManager.search(startDate, endDate, brand, type, year, fuel, pageable);
    }
    @GetMapping("getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(carService.getById(id));
    }
}
