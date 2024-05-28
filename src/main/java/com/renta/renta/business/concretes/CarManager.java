package com.renta.renta.business.concretes;

import com.renta.renta.business.abstracts.CarService;
import com.renta.renta.business.dtos.responses.get.car.GetAllCarResponse;
import com.renta.renta.dataAccess.CarRepository;
import com.renta.renta.dataAccess.CarSpecifications;
import com.renta.renta.entities.Car;
import com.renta.renta.utilities.mapping.ModelMapperManager;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private CarRepository carRepository;

    private ModelMapperManager modelMapperManager;

    public List<GetAllCarResponse> search(LocalDate startDate, LocalDate endDate, String brand, String type, Integer year, String fuel, Pageable pageable) {
        Specification<Car> baseSpecification = Specification.where(CarSpecifications.hasNotBooked(startDate, endDate));

        if (StringUtils.isNotEmpty(brand)) {
            baseSpecification = baseSpecification.and(CarSpecifications.hasBrand(brand));
        }

        if (StringUtils.isNotEmpty(type)) {
            baseSpecification = baseSpecification.and(CarSpecifications.hasType(type));
        }

        if (year != null) {
            baseSpecification = baseSpecification.and(CarSpecifications.hasYear(year));
        }

        if (StringUtils.isNotEmpty(fuel)) {
            baseSpecification = baseSpecification.and(CarSpecifications.hasFuel(fuel));
        }

        Page<Car> cars = carRepository.findAll(baseSpecification, pageable);

        return cars.stream().map(car-> modelMapperManager.forRequest().map(car, GetAllCarResponse.class)).toList();
    }
}
