package com.thread.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PrintXlsxFile {
	public static void printExcelFile(FileInputStream fis) throws IOException, InterruptedException {
		// create a WorkBook
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// create a Sheet
		XSSFSheet sheet = wb.getSheetAt(0);

		// iterate over the excel file
		Iterator<Row> it = sheet.iterator();

		// iterate each row
		while (it.hasNext()) {
			Row row = it.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			// iterate each column
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case STRING: // field that represents string cell type
					System.out.printf("%-18s", cell.getStringCellValue());
					break;
				case NUMERIC: // field that represents numeric cell type
					System.out.printf("%-18s", cell.getNumericCellValue());
					break;
				default:
				}
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------");
	}
}
