package com.dyplom.service;

import com.dyplom.domain.car.Brand;
import com.dyplom.domain.car.Car;
import com.dyplom.domain.car.CarNumber;
import com.dyplom.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {
    private final CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car add(String carModel, CarNumber carNumber, Brand brand, int yearOfProduction, String vinNumber) {
        var car = new Car(
                carModel,
                carNumber,
                brand,
                yearOfProduction,
                vinNumber);
        return carRepository.save(car);
    }
}
