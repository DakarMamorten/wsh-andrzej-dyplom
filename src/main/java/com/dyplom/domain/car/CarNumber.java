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

    private String regNo;

    @Enumerated(EnumType.STRING)
    private CountryRegistration countryRegion;

    public CarNumber(String regNo, CountryRegistration countryRegion) {
        this.regNo = regNo;
        this.countryRegion = countryRegion;
    }
}
