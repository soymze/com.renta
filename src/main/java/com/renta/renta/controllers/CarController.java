package com.renta.renta.controllers;

import com.renta.renta.business.abstracts.CarService;
import com.renta.renta.dataAccess.CarRepository;
import com.renta.renta.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {

    private CarService carService;

/*@PostMapping
    public void add(@RequestBody Car car){
        carService.add(car);
    }
@GetMapping("getall")
    public List<Car> getAll(){
    return carService.getAll();
    }*/
}
