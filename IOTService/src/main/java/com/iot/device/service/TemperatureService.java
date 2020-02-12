package com.iot.device.service;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.device.dto.TemperatureDto;
import com.iot.device.enums.MeasurementTypeEnum;
import com.iot.device.model.Temperature;
import com.iot.device.properties.ApplicationProperties;
import com.iot.device.repository.TemperatureRepository;
import com.iot.device.sender.Sender;
import com.iot.device.utility.ConvertJson;


@Service
public class TemperatureService extends BaseService {

	@Autowired
	private Sender sender;
	
	@Autowired
	TemperatureRepository temperatureRepository;
	
	@Autowired
	ApplicationProperties applicationProperties;
	
	@Autowired
	ConvertJson<TemperatureDto> convert;
	
	public void send() {
		
		int portNumber=applicationProperties.getPortNumber();
		String ipAddress = applicationProperties.getFogServerIpAddress();
		TemperatureDto temperature = getLastMeasurement();
		String jsonData = convert.convertToJson(temperature);
		if(!jsonData.isEmpty())
			sender.send(ipAddress, portNumber, jsonData); 
	}
	
	
	private TemperatureDto getLastMeasurement() {
		
		Temperature temperature = temperatureRepository.findFirstByOrderByIdDesc();
		return convertToDto(temperature);
	}
	
	private TemperatureDto convertToDto(Temperature temperature) {
		TemperatureDto dto = new TemperatureDto();
		dto.setDeviceId(temperature.getDeviceId());
		dto.setMeasurement(temperature.getMeasurement());
		dto.setMeasurementType(temperature.getMeasurementType());
		dto.setMeasurementTypeValue(getMeasurementTypeValue(temperature.getMeasurementType()));
		return dto;
	}
	
	private String getMeasurementTypeValue(MeasurementTypeEnum measurementType) {
		
		String result="";
		if(measurementType == MeasurementTypeEnum.CENTIGRADE) {
			result = "C";
		}
		else if(measurementType == MeasurementTypeEnum.FAHRENHEIT) {
			result = "F";
		}
		return result;
	}
	
	
	public void AddTemperature(String json) {
		
		logger.info("TemperatureService.java --> AddTemperature()");
		TemperatureDto dto;
		try {
			dto = convert.parser(json, TemperatureDto.class);
			Temperature temperature = convertToModel(dto);
			temperatureRepository.saveAndFlush(temperature);
		} catch (InstantiationException | IllegalAccessException | IOException e) {
			logger.info("TemperatureService.java --> AddTemperature() -- error: "+e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("TemperatureService.java --> AddTemperature() -- added");
		
	}
	
	private Temperature convertToModel(TemperatureDto dto) {
		logger.info("TemperatureService.java --> convertToModel()");
		Temperature model = new Temperature();
		model.setCreatedBy(2);
		model.setCreatedDate(new Date());
		model.setDeviceId(dto.getDeviceId());
		model.setMeasurement(dto.getMeasurement());
		model.setMeasurementType(dto.getMeasurementType());
		
		return model;
	}

}
