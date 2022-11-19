package com.dyplom.domain.car;

public enum CountryRegistration {
    A("Austria"),
    AL("Albania"),
    AM("Armenia"),
    BY("Belarus"),
    CZ("Czech Republic\t"),
    E("Spain"),
    ENG("England"),
    F("France"),
    H("Hungary"),
    IRL("Ireland"),
    LV("Latvia"),
    PL("Poland"),
    DE("Germany"),
    UA("Ukraine");

    private final String countryName;

    CountryRegistration(String countryName) {
        this.countryName = countryName;
    }


}
