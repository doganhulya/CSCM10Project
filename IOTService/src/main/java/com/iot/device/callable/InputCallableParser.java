package com.iot.device.callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iot.device.service.TemperatureService;

@Component
public class InputCallableParser extends BaseCallable{

	@Autowired
	private TemperatureService temperatureService;
	
	@Override
	public Object call() throws Exception {
		
		logger.info("InputCallableParser.java --> call()");
		temperatureService.AddTemperature(getJsonData());
		return 1;
	}

}
