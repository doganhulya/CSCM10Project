package com.iot.device.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "application")
@Component
public class ApplicationProperties {
	
	private int portNumber;
	private String fogServerIpAddress;

	public int getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	public String getFogServerIpAddress() {
		return fogServerIpAddress;
	}

	public void setFogServerIpAddress(String fogServerIpAddress) {
		this.fogServerIpAddress = fogServerIpAddress;
	}
	
}
