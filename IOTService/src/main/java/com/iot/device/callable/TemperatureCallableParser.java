package com.iot.device.callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iot.device.service.TemperatureService;

@Component
public class TemperatureCallableParser extends BaseCallable {

	@Autowired
	private TemperatureService temperatureService;
	
	@Override
	public Object call() throws Exception {
		
		temperatureService.send();
		return 1;
	}

}
