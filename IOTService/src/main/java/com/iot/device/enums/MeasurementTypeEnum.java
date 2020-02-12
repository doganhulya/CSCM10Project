package com.iot.device.enums;

public enum MeasurementTypeEnum {

	CENTIGRADE(0),    
	FAHRENHEIT(1);

	private int value;

	MeasurementTypeEnum(int val) {
		this.value = val;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
