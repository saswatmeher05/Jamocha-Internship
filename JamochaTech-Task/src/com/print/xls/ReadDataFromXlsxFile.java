package com.print.xls;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromXlsxFile {

	public static void main(String[] args) {
		try {

			// get the file using FileInputStream
			FileInputStream fis = new FileInputStream(new File("C:\\Users\\saswa\\Documents\\StudentDetails.xlsx"));

			// create a workbook instance that refers to the xlsx file
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// create a Sheet to retrieve the object
			XSSFSheet sheet = wb.getSheetAt(0);

			// iterate over excel file
			Iterator<Row> it = sheet.iterator();

			while (it.hasNext()) {
				Row row = it.next();
				// iterate each column
				Iterator<Cell> cellIterator = row.cellIterator();
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
				System.out.println("");
			}
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
