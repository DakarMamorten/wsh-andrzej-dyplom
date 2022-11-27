package com.dyplom.domain.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carId;
    private String model;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carNumberId")
    private CarNumber carNumber;
    @Enumerated(EnumType.STRING)
    private Brand brand;
    private int yearOfProduction;
    private String vinNumber;
    private String oldRegistryNumber;

    public Car(String model, CarNumber carNumber, Brand brand, int yearOfProduction, String vinNumber) {
        this.model = model;
        this.carNumber = carNumber;
        this.brand = brand;
        this.yearOfProduction = yearOfProduction;
        this.vinNumber = vinNumber;
    }
}
