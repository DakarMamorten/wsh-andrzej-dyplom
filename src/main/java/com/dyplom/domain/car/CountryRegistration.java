package com.dyplom.domain.car;

public enum CountryRegistration {
    PL("Poland"),
    DE("Germany");

    private final String countryName;

    CountryRegistration(String countryName) {
        this.countryName = countryName;
    }


}
