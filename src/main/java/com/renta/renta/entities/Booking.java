package com.renta.renta.entities;

import com.renta.renta.core.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Booking extends BaseEntity<Integer> {

    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;

    private Double price;

    private LocalDate bookDate;
}
