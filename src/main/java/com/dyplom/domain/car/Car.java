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
    private String brand;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carNumberId")
    private CarNumber carNumber;
    @Enumerated(EnumType.STRING)
    private Model model;
    private int yearOfProduction;
    private String vinNumber;
    private String oldRegistryNumber;

    public Car(CarNumber carNumber, String brand, Model model, int yearOfProduction, String vinNumber) {
        this.carNumber = carNumber;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.vinNumber = vinNumber;
    }
}
