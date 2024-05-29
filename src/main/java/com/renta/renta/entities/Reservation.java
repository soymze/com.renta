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
@Table(name = "reservations")
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Reservation extends BaseEntity<Integer> {


    private String userFullName;

    private String emailAddress;

    private String phoneNumber;

    @ManyToOne
    private Car car;

    private LocalDate startDate;

    private LocalDate endDate;

    private Double totalPrice;
}
