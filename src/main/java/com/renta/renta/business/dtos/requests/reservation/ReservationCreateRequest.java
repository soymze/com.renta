package com.renta.renta.business.dtos.requests.reservation;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ReservationCreateRequest implements Serializable {

    private Integer carId;
    private LocalDate startDate;
    private LocalDate endDate;
}
