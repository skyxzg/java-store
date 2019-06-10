package com.taobao.yiwei.datadrive.filerunners;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import com.opencsv.CSVReader;

public class CsvParser {

	@SuppressWarnings("resource")
	public static ParamTable generateTable(String fileName) {
		ParamTable table = new ParamTable();

		try {
			File file = new File(fileName);
			CSVReader csvReader = new CSVReader(new FileReader(file), ';');

			List<String[]> list = csvReader.readAll();
			int rowCount = list.size();
			if (rowCount < 2) {
				throw new RuntimeException("Data incomplete! file:" + fileName);
			}

			// decode top row
			String[] topRow = list.get(0);
			table.setColumnLabel(topRow);

			// decode other rows
			for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
				HashMap<String, String> map = new HashMap<String, String>();
				String[] rowArray = list.get(rowIndex);
				for (int columnIndex = 0; columnIndex < rowArray.length; columnIndex++) {
					map.put(topRow[columnIndex], rowArray[columnIndex]);
				}
				table.addRow(map);
			}
		
			csvReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return table;
	}

}

