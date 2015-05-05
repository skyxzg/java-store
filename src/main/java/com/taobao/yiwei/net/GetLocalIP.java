package com.taobao.yiwei.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetLocalIP {
	
	public String getLocalIP() {
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			System.err.println(e.toString());
		}
		return addr.getHostAddress(); //获得本机IP
	}
	
	public String getLocalHostName() {
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			System.err.println(e.toString());
		}
		return addr.getHostName(); //获得本机名称
	}
}
