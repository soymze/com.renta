package com.renta.renta.entities;

import com.renta.renta.core.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "brand may not be null")
    private String brand;
    @Column(name="model")
    @NotNull(message = "model may not be null")
    private String model;
    @Column(name="year")
    @NotNull(message = "year may not be null")
    private Integer year;
    @Column(name="color")
    private String color;
    @Column(name="speed")
    private String speed;
    @Column(name="fuel")
    @NotNull(message = "fuel may not be null")
    private String fuel;
    @Column(name="type")
    private String type;
    @Column(name="price")
    @NotNull(message = "price may not be null")
    private Integer price;
    @Column(name="img_url")
    private String img_url;
}
