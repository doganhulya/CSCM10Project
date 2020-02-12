package com.iot.device.dto;

import com.iot.device.enums.MeasurementTypeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureDto {
	
	private double measurement;
	private MeasurementTypeEnum measurementType;
	private String deviceId;
	private String measurementTypeValue;
}
