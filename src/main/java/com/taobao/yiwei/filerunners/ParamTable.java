package com.taobao.yiwei.filerunners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ParamTable {

	private List<Map<String, String>> table = new ArrayList<Map<String, String>>();
	private List<String> columnLabel = new ArrayList<String>();

	public boolean isEmpty() {
		return table.size() == 0;
	}
	
	public void setColumnLabel(String[] str) {
		columnLabel = Arrays.asList(str);
	}

	public List<String> getColumnLabel() {
		return columnLabel;
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
