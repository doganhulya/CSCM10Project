package com.iot.device.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.iot.device.enums.MeasurementTypeEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TEMPERATURE")
@Getter
@Setter
public class Temperature extends BaseEntity{

	private double measurement;
	private MeasurementTypeEnum measurementType;
	private String deviceId;
	
}
