package com.renta.renta.business.concretes;

import com.renta.renta.business.abstracts.ReservationService;
import com.renta.renta.business.dtos.requests.reservation.ReservationCreateRequest;
import com.renta.renta.business.dtos.responses.get.car.GetCarResponse;
import com.renta.renta.business.dtos.responses.reservation.PrepareReservationResponse;
import com.renta.renta.dataAccess.BookingRepository;
import com.renta.renta.dataAccess.ReservationRepository;
import com.renta.renta.entities.Booking;
import com.renta.renta.entities.Car;
import com.renta.renta.entities.Reservation;
import com.renta.renta.utilities.results.Result;
import com.renta.renta.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@AllArgsConstructor
public class ReservationManager implements ReservationService {

    private ReservationRepository reservationRepository;

    private BookingRepository bookingRepository;

    private CarManager carManager;

    //private UserManager userManager;

    public PrepareReservationResponse prepareReservation(Long carId, LocalDate startDate, LocalDate endDate) {
        GetCarResponse carResponse = carManager.getCarResponseById(carId);

        long days = DAYS.between(startDate, endDate);
        double totalPrice = days * carResponse.getPrice();

        return PrepareReservationResponse.builder()
                .car(carResponse)
                .startDate(startDate)
                .endDate(endDate)
                .totalPrice(totalPrice)
                .build();
    }

    public Result completeReservation(ReservationCreateRequest reservationRequest) {

        Car car = carManager.getById(reservationRequest.getCarId());

        long days = DAYS.between(reservationRequest.getStartDate(), reservationRequest.getEndDate());

        LocalDateTime now = LocalDateTime.now();
        LocalDate bookDate = reservationRequest.getStartDate();

        for (int i=0;i<days;i++) {
            Booking booking = new Booking();

            booking.setCar(car);
            booking.setPrice(car.getPrice());
            booking.setCreatedDate(now);
            booking.setUpdatedDate(now);

            bookDate = bookDate.plusDays(i);
            booking.setBookDate(bookDate);

            bookingRepository.save(booking);
        }

        Reservation reservation = new Reservation();
        reservation.setCreatedDate(now);
        reservation.setUpdatedDate(now);
        reservation.setCar(car);
        reservation.setTotalPrice(days * car.getPrice());

        reservation.setUserFullName("Test User");

        reservationRepository.save(reservation);

        return new SuccessResult("success");
    }
}
