package com.iot.device.callable;

import org.springframework.beans.factory.annotation.Autowired;

public class InputRunCallableParser extends BaseRunCallableParser {

	@Autowired
	InputCallableParser inputCallableParser;
	
	@SuppressWarnings("unchecked")
	@Override
	public void run(String json) {
		logger.info("InputRunCallableParser.java --> run() -- json: "+json);
		inputCallableParser.setJsonData(json);
		pool.submit(inputCallableParser);
	}

}
