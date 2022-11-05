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
    private String regNo;
    private String fullName;
    private String brand;
    private String model;
    private int yearOfProduction;
    private String vinNumber;
    private String oldRegistryNumber;

    public Car(String regNo, String fullName, String brand, String model, int yearOfProduction, String vinNumber, String oldRegistryNumber) {
        this.regNo = regNo;
        this.fullName = fullName;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.vinNumber = vinNumber;
        this.oldRegistryNumber = oldRegistryNumber;
    }
}
