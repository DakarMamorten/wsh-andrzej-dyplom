package com.dyplom.service;

import com.dyplom.domain.Car;
import com.dyplom.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> findAll(){
        return carRepository.findAll();
    }
}
