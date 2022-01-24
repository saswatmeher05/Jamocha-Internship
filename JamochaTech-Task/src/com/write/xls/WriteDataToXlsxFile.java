package com.write.xls;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteDataToXlsxFile {

	public static void main(String[] args) {
		List<EmployeeDTO> list=new ArrayList<EmployeeDTO>();
		list.add(new EmployeeDTO("Somu", "Meher",23, "male", "dev", "java,html,css", "29-11-2022", "sonepur", "odisha"));
		list.add(new EmployeeDTO("Somu", "Meher",23, "male", "dev", "java,html,css", "29-11-2022", "sonepur", "odisha"));
		list.add(new EmployeeDTO("Somu", "Meher",23, "male", "dev", "java,html,css", "29-11-2022", "sonepur", "odisha"));
		list.add(new EmployeeDTO("Somu", "Meher",23, "male", "dev", "java,html,css", "29-11-2022", "sonepur", "odisha"));
		list.add(new EmployeeDTO("Somu", "Meher",23, "male", "dev", "java,html,css", "29-11-2022", "sonepur", "odisha"));
		
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(); 
			XSSFSheet sheet=workbook.createSheet("sheet1");	//creates a blank sheet
			int rownum=0;
			
			for(EmployeeDTO dto:list) {
				Row row=sheet.createRow(rownum++);
				
				Cell cell=row.createCell(0);
				cell.setCellValue(dto.getFname());
				
				cell=row.createCell(1);
				cell.setCellValue(dto.getLname());
				
				cell=row.createCell(2);
				cell.setCellValue(dto.getAge());
				
				cell=row.createCell(3);
				cell.setCellValue(dto.getGender());
				
				cell=row.createCell(4);
				cell.setCellValue(dto.getDesg());
				
				cell=row.createCell(5);
				cell.setCellValue(dto.getSkills());
				
				cell=row.createCell(6);
				cell.setCellValue(dto.getDoj());
				
				cell=row.createCell(7);
				cell.setCellValue(dto.getCity());
				
				cell=row.createCell(8);
				cell.setCellValue(dto.getState());
			}	
			
			FileOutputStream out=new FileOutputStream(new File("D:\\export.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Success");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Failed");
		}

	}

}
