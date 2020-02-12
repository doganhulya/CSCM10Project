package com.iot.device.callable;

import org.springframework.beans.factory.annotation.Autowired;

public class TemperatureRunCallableParser extends BaseRunCallableParser {

	@Autowired
	TemperatureCallableParser temperatureCallableParser;
	
	@SuppressWarnings("unchecked")
	@Override
	public void run(String jsonData) {
		
		logger.info("TemperatureRunCallableParser.java --> run()");
		temperatureCallableParser.setJsonData(jsonData);
		pool.submit(temperatureCallableParser);
	}

}
