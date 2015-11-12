package com.taobao.yiwei.filerunners;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class XlsParser {

	public static ParamTable generateTable(String fileName, String sheetName) {
		ParamTable table = new ParamTable();

		try {
			Workbook book = Workbook.getWorkbook(new File(fileName));
			Sheet sheet = null;
			if (sheetName == null || sheetName.isEmpty()) {
				sheet = book.getSheet(0);
			} else {
				sheet = book.getSheet(sheetName);
			}

			int rowCount = sheet.getRows();
			if (rowCount < 2)
				throw new RuntimeException("Data incomplete! file:" + fileName + ", sheet:" + sheetName);
			int columnCount = sheet.getColumns();

			// decode first row
			String[] topRow = new String[columnCount];
			Cell[] topCellArray = sheet.getRow(0);
			for (int index = 0; index < columnCount; index++) {
				topRow[index] = topCellArray[index].getContents();
			}
			table.setItems(topRow);

			// decode other rows
			for (int row = 1; row < rowCount; row++) {
				Map<String, String> map = new HashMap<String, String>();
				Cell[] cellArray = sheet.getRow(row);
				for (int column = 0; column < cellArray.length; column++) {
					map.put(topRow[column], cellArray[column].getContents());
				}
				table.addRow(map);
			}
			
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return table;
	}

}
