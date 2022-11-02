package com.dyplom.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carId;
    private int regNo;
    private String fullName;
    private String brand;
    private String model;
    private int yearOfProduction;
    private long vinNumber;
    private String oldRegistryNumber;

    public Car(int regNo, String fullName, String brand, String model, int yearOfProduction, long vinNumber, String oldRegistryNumber) {
        this.regNo = regNo;
        this.fullName = fullName;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.vinNumber = vinNumber;
        this.oldRegistryNumber = oldRegistryNumber;
    }
}
