package com.iot.device.callable;

import org.springframework.beans.factory.annotation.Autowired;

import com.iot.device.service.BaseService;


public abstract class BaseServiceCallable<S extends BaseService> extends BaseCallable {

	@Autowired
	S service;

	public BaseServiceCallable() {
		
	
	}

	
}