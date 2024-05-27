package com.renta.renta.entities;

import com.renta.renta.core.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Car extends BaseEntity<Integer> {

    @Column(name="brand")
    private String brand;
    @Column(name="model")
    private String model;
    @Column(name="year")
    private Integer year;
    @Column(name="color")
    private String color;
    @Column(name="speed")
    private String speed;
    @Column(name="fuel")
    private String fuel;
    @Column(name="type")
    private String type;
    @Column(name="price")
    private Integer price;
}
