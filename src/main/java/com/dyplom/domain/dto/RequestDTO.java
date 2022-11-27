package com.dyplom.domain.dto;

import lombok.Data;

@Data
public class RequestDTO {
    private String carModel;
    private String carBrand;
    private String carNumber;
    private String countryRegion;
    private int yearOfProduction;
    private String vinNumber;
}
