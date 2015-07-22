package com.taobao.yiwei.json;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;


public class ParseJson {
	
	public static String configFile = "etc/json.conf";
	
	public static void main(String[] args) { 
		System.out.println("Hello world!");
		String jsonStr = "";
		
		try {
			String line = null;
			BufferedReader br = new BufferedReader(new FileReader(configFile));
			while ((line = br.readLine()) != null) {
				jsonStr += line;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("jsonStr:" + jsonStr);
		
		JSONObject jsonObject = new JSONObject(jsonStr);
		String project = jsonObject.getString("project");
		System.out.println("project:" + project);
		String version = jsonObject.getString("version");
		System.out.println("version:" + version);
		JSONArray team = jsonObject.getJSONArray("team");
		for (int i = 0; i < team.length(); i++) {
			JSONObject ele = team.getJSONObject(i);
			String name = ele.getString("name");
			System.out.println("name:" + name);
			String skill = ele.getString("skill");
			System.out.println("skill:" + skill);
		}
		
	}
    
}
