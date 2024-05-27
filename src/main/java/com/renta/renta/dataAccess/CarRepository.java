package com.renta.renta.dataAccess;

import com.renta.renta.entities.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarRepository extends PagingAndSortingRepository<Car, Integer> {

   // void add();

    @Query("SELECT c FROM Car c WHERE NOT EXISTS(SELECT 1 FROM Booking b WHERE b.car=c)")
    List<Car> list();
}
