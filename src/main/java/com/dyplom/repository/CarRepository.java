package com.dyplom.repository;

import com.dyplom.domain.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long>{

}
