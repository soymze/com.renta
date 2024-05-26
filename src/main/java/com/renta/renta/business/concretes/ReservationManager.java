package com.renta.renta.business.concretes;

import com.renta.renta.business.abstracts.ReservationService;
import com.renta.renta.dataAccess.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationManager implements ReservationService {

    private ReservationRepository reservationRepository;
}
