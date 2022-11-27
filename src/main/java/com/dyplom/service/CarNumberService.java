package com.dyplom.service;

import com.dyplom.domain.car.CarNumber;
import com.dyplom.repository.CarNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarNumberService {
    private final CarNumberRepository carNumberRepository;

    public void save(CarNumber entity) {
        carNumberRepository.save(entity);
    }
}
