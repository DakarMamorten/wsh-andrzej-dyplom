package com.dyplom.domain;

import com.dyplom.domain.car.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime dateCreate = LocalDateTime.now();

    public Request(Car car, User user) {
        this.car = car;
        this.user = user;
    }

    public Car getCarString() {
        return new Car(car.getCarId(),car.getBrand(),car.getCarNumber(),car.getModel(),car.getYearOfProduction(),car.getVinNumber(),car.getOldRegistryNumber());
    }
}
