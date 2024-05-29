package com.renta.renta.dataAccess;

import com.renta.renta.entities.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
}
