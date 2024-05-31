package com.renta.renta.business.dtos.responses.reservation;

import com.renta.renta.business.dtos.responses.get.car.GetCarResponse;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Builder
public class PrepareReservationResponse implements Serializable {

    private GetCarResponse car;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalPrice;
}
