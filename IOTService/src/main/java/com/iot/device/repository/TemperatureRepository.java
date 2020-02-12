package com.iot.device.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.iot.device.model.Temperature;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
	
	Temperature findFirstByOrderByIdDesc();
}
