package com.employee.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.employee.model.EmployeeDTO;

public class EmployeeDataExcelExport extends AbstractXlsxView {
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// define excel file name to be exported
		response.addHeader("Content-Disposition", "attachment;fileName=EmployeeData "+new SimpleDateFormat("dd-MM-yyy hh-mm-ss").format(new Date())+".xlsx");

		// read data provided by controller
		@SuppressWarnings("unchecked")
		List<EmployeeDTO> list = (List<EmployeeDTO>) model.get("list");

		// create one sheet
		Sheet sheet = workbook.createSheet("Sheet1");
		CellStyle style=workbook.createCellStyle();
		Font font=workbook.createFont();
		font.setBold(true);
		style.setFont(font);
		// create row0 as header
		Row row0 = sheet.createRow(0);
		row0.setRowStyle(style);
		// create cells
		Cell cell0=row0.createCell(0);
		cell0.setCellStyle(style);
		cell0.setCellValue("First Name");
		
		Cell cell1=row0.createCell(1);
		cell1.setCellStyle(style);
		cell1.setCellValue("Last Name");
		
		Cell cell2=row0.createCell(2);
		cell2.setCellStyle(style);
		cell2.setCellValue("Age");
		
		Cell cell3=row0.createCell(3);
		cell3.setCellStyle(style);
		cell3.setCellValue("Gender");
		
		Cell cell4=row0.createCell(4);
		cell4.setCellStyle(style);
		cell4.setCellValue("Designation");
		
		Cell cell5=row0.createCell(5);
		cell5.setCellStyle(style);
		cell5.setCellValue("Skills");
		
		Cell cell6=row0.createCell(6);
		cell6.setCellStyle(style);
		cell6.setCellValue("DOJ");
		
		Cell cell7=row0.createCell(7);
		cell7.setCellStyle(style);
		cell7.setCellValue("City");
		
		Cell cell8=row0.createCell(8);
		cell8.setCellStyle(style);
		cell8.setCellValue("State");

		// create row1 onwards
		int rowNum = 1;
		for (EmployeeDTO dto : list) {
			Row row = sheet.createRow(rowNum++);			
			row.createCell(0).setCellValue(dto.getFname());
			row.createCell(1).setCellValue(dto.getLname());
			row.createCell(2).setCellValue(dto.getAge());
			row.createCell(3).setCellValue(dto.getGender());
			row.createCell(4).setCellValue(dto.getDesg());
			row.createCell(5).setCellValue(dto.getSkills());
			row.createCell(6).setCellValue(dto.getDoj());
			row.createCell(7).setCellValue(dto.getCity());
			row.createCell(8).setCellValue(dto.getState());
		}

	}
}
