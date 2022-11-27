package com.dyplom.repository;

import com.dyplom.domain.car.CarNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarNumberRepository extends JpaRepository<CarNumber, Long> {
}
