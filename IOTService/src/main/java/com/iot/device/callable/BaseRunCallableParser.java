package com.iot.device.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;


public abstract class BaseRunCallableParser {
	
	protected static final ExecutorService pool = Executors.newFixedThreadPool(50);
	
	protected static final Logger logger = Logger.getLogger(BaseRunCallableParser.class);

	public abstract void run(String json);
}
