package com.taobao.yiwei.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetLocalHost {
	
	public static InetAddress localAddr;
	
	static {
		try {
			localAddr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			System.err.println(e.toString());
		}
	}

	public static void main(String[] args){
		System.out.println("Local IP:" + localAddr.getHostAddress()); //获得本机IP
		System.out.println("Local host name:" + localAddr.getHostName()); //获得本机名称
	}
}
