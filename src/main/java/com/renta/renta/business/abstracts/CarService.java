package com.renta.renta.business.abstracts;

import com.renta.renta.business.dtos.responses.get.car.GetCarResponse;
import com.renta.renta.utilities.results.DataResult;

public interface CarService {

    DataResult<GetCarResponse> getResultById(Integer id);
}
