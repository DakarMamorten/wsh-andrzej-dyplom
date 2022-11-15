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
    private String regNo;
    @Enumerated(EnumType.STRING)
    private CountryRegistration countryReg;
    private String brand;
    @Enumerated(EnumType.STRING)
    private Model model;
    private int yearOfProduction;
    private String vinNumber;
    private String oldRegistryNumber;
}
