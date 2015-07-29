package com.baotao.yiwei.filerunners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ParamTable {

	private List<Map<String, String>> table = new ArrayList<Map<String, String>>();
	private List<String> items = new ArrayList<String>();

	public boolean isEmpty() {
		return table.size() == 0;
	}
	
	public void setItems(String[] str) {
		items = Arrays.asList(str);
	}

	public List<String> getItems() {
		return items;
	}

	public int size() {
		return table.size();
	}

	public void addRow(Map<String, String> map) {
		table.add(map);
	}

	public Map<String, String> getRow(int index) {
		return table.get(index);
	}
}
