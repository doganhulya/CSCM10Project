package com.iot.device.callable;

import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import javax.persistence.MappedSuperclass;



@SuppressWarnings("rawtypes")
@MappedSuperclass
public abstract class BaseCallable implements Callable {

	protected static Logger logger = Logger.getLogger(BaseCallable.class);

	private String jsonData;
	
	public BaseCallable() {

	}

	
	public BaseCallable(String jsonData) {
		setJsonData(jsonData);
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

}
