package com.print.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class ReadDataFromXlsFile {
	public static void main(String[] args) throws IOException{
		//Read file from system
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\saswa\\Documents\\StudentDetailsOld.xls"));
		//create workbook instance that refers to the excel file 
		HSSFWorkbook workbook=new HSSFWorkbook(fis);
		
		//create a sheet object to retrieve the object
		HSSFSheet sheet=workbook.getSheetAt(0);
		
		//evaluate the cell type
		FormulaEvaluator evaluator=workbook.getCreationHelper().createFormulaEvaluator();
		//iterate row using for-each loop
		for(Row row:sheet) {
			//iterate cell using for-each loop
			for(Cell cell:row) {
				switch(evaluator.evaluateInCell(cell).getCellType()) {
				case STRING: //field that represents string cell type
					System.out.printf("%-18s",cell.getStringCellValue());
					break;
				case NUMERIC: //field that represents numeric cell type
					System.out.printf("%-18s",cell.getNumericCellValue());
					break;
				}
			}
			System.out.println();
		}
		
		workbook.close();
	}
}
