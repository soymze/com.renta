package com.renta.renta.business.abstracts;

import com.renta.renta.business.dtos.responses.get.car.GetCarResponse;
import com.renta.renta.entities.Car;
import com.renta.renta.utilities.results.DataResult;

import java.util.List;

public interface CarService {

    DataResult<GetCarResponse> getById(int id);
}
