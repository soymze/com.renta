package com.renta.renta.controllers;

import com.renta.renta.business.concretes.ReservationManager;
import com.renta.renta.business.dtos.requests.reservation.ReservationCreateRequest;
import com.renta.renta.business.dtos.responses.reservation.PrepareReservationResponse;
import com.renta.renta.utilities.results.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/reservations")
@AllArgsConstructor
public class ReservationController {

    private ReservationManager reservationManager;

    @GetMapping("prepareReservation/{carId}")
    public ResponseEntity<PrepareReservationResponse> prepareReservation(@PathVariable("carId")Integer carId,
                                                                         @RequestParam(value = "startDate") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate startDate,
                                                                         @RequestParam(value = "endDate") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate endDate) {
        return ResponseEntity.ok().body(reservationManager.prepareReservation(carId, startDate, endDate));
    }

    @PostMapping("reserve")
    public ResponseEntity<Result> completeReservation(@Valid @RequestBody ReservationCreateRequest reservationRequest) {

        reservationManager.completeReservation(reservationRequest);

        return ResponseEntity.ok().build();
    }
}
