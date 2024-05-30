package com.renta.renta.business.concretes;

import com.renta.renta.business.abstracts.CarService;
import com.renta.renta.business.dtos.responses.get.car.GetAllCarResponse;
import com.renta.renta.business.dtos.responses.get.car.GetCarResponse;
import com.renta.renta.dataAccess.CarRepository;
import com.renta.renta.dataAccess.CarSpecifications;
import com.renta.renta.entities.Car;
import com.renta.renta.utilities.mapping.ModelMapperManager;
import com.renta.renta.utilities.mapping.ModelMapperService;
import com.renta.renta.utilities.results.DataResult;
import com.renta.renta.utilities.results.SuccessDataResult;
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
    private ModelMapperService mapperService;
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

    @Override
    public DataResult<GetCarResponse> getResultById(Integer id) {
        Car car = carRepository.findById(id);
        GetCarResponse response =
                mapperService.forResponse().map(car, GetCarResponse.class);
        return new SuccessDataResult<>(response);
    }

    public Car getById(Integer carId) {
        return carRepository.findOne(CarSpecifications.byId(carId)).orElseThrow(() -> new RuntimeException("Car could not be found"));
    }
}
