package com.taobao.yiwei.net;

public class Main {

	public static void main(String[] args){
		System.out.println("Hello world!");
		
		GetLocalIP localIP = new GetLocalIP();
		System.out.println("Local IP:" + localIP.getLocalIP());
		System.out.println("Local host name:" + localIP.getLocalHostName());
	}
}
