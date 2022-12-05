package com.dyplom.domain.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CarNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    private CountryRegistration countryRegion;

    public CarNumber(String registrationNumber, CountryRegistration countryRegion) {
        this.registrationNumber = registrationNumber;
        this.countryRegion = countryRegion;
    }
}
