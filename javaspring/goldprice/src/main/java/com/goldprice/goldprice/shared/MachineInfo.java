package com.goldprice.goldprice.shared;

import java.net.DatagramSocket;
import java.net.InetAddress;

import com.goldprice.goldprice.exception.TokenException;

public class MachineInfo {
	/*
	 * Get Ip Machine
	 *
	 * return String Ip adress machine
	 */
	public String getIpAddress() {
		try (final DatagramSocket socket = new DatagramSocket()) {
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			String ip = socket.getLocalAddress().getHostAddress();
			return ip;
		} catch (Exception e) {
			throw new TokenException("Ip Address Is Not Found, Please Contact Admin!");
		}
	}
	
	/*
	 * Get Name Machine
	 *
	 * return String Name machine
	 */
	public String getNameMachine() {
		try (final DatagramSocket socket = new DatagramSocket()) {
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			String name = socket.getLocalAddress().getHostName();
			return name;
		} catch (Exception e) {
			throw new TokenException("Name Machine Is Not Found, Please Contact Admin!");
		}
	}
}
