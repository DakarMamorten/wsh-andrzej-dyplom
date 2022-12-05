package com.dyplom.domain.dto;

import com.dyplom.domain.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestDTO {
    private long id;
    private String identifier;
    private String carModel;
    private String carBrand;
    private String username;
    private String registrationNumber;
    private String countryRegion;
    private int yearOfProduction;
    private String vinNumber;
    private Status status;
    private LocalDateTime date = LocalDateTime.now();
}
