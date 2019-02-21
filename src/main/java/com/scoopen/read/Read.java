package com.scoopen.read;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read {
	public static void main(String[] args) throws IOException {
		readdata();
	}

	@SuppressWarnings("static-access")
	public static Object[][] readdata() throws IOException {
		Object[][] udata = new Object[6][3];
		XSSFWorkbook book = new XSSFWorkbook("E:\\SCOOPEN\\Student.xlsx");
		XSSFSheet sheet = book.getSheet("StudentSheet2");
		Iterator<Row> rows = sheet.rowIterator(); // iterator on sheet for row
		int rowcount = 0;
		int cellcount = 0;
		rows.next();

		while (rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator(); // iterator on row for
														// cell
			while (cells.hasNext()) {
				Cell cell = cells.next();

				if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
					udata[rowcount][cellcount] = (int) cell.getNumericCellValue();
					continue;
				} else {
					String cellvalue = cell.getStringCellValue().equalsIgnoreCase("NA") ? null
							: cell.getStringCellValue();
					udata[rowcount][cellcount] = cellvalue;
					cellcount++;
				}

			}
			rowcount++;
			cellcount = 0;

		}
		return udata;

	}

}
