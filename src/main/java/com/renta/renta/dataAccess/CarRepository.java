package com.renta.renta.dataAccess;

import com.renta.renta.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

   // void add();
}
