package com.iot.device.sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


@Component
public class Sender {

	private static Logger logger = Logger.getLogger(Sender.class);
	
	public void send(String ip, int portNumber, String jsonData) {
		logger.info("Sender.java --> send() method");

		InetAddress address;
		byte[] message = new byte[jsonData.length()];
		
		try(DatagramSocket dsocket = new DatagramSocket()) {
			
			message = jsonData.getBytes();
			logger.info("Sender.java --> send() --> port:  "+ portNumber);
			logger.info("Sender.java --> send() --> data: "+ jsonData);
			
			address = InetAddress.getByName(ip);
			logger.info("Sender.java --> send() method ip: " + ip + " inetAdress: " + address + " -- message: " + Arrays.toString(message));
			
			DatagramPacket packet = new DatagramPacket(jsonData.getBytes(), jsonData.length(), address, portNumber);
			logger.info("Sender.java --> send() --> packet:  "+ packet);
			
			dsocket.send(packet);
			dsocket.setSoTimeout(1010);
			dsocket.close();
			
			logger.info("Sender.java --> send() -- data sended --> data packet: "+ jsonData);
			
		}catch (SocketException e) {
			logger.error("Sender.java --> sendMessage() socketException: "+e.getMessage());
		} catch (UnknownHostException e) {
			logger.error("Sender.java --> sendMessage() UnknownHostException: "+e.getMessage());
		} catch (IOException e) {
			logger.error("Sender.java --> sendMessage() IOException: "+e.getMessage());
		}//End catch block
	}
}
