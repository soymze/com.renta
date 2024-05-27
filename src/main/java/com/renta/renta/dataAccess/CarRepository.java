package com.renta.renta.dataAccess;

import com.renta.renta.entities.Car;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, Integer>, JpaSpecificationExecutor<Car> {
}
