package com.employee.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.employee.model.EmployeeDTO;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class EmployeeDataPdfExport extends AbstractPdfView {
	@Override
	protected void buildPdfDocument(Map<String, Object> model, com.lowagie.text.Document document, PdfWriter writer,HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition", "attachment;fileName=EmployeeData "+ new SimpleDateFormat("dd-MM-yyy hh-mm-ss").format(new Date()) + ".pdf");
		
		@SuppressWarnings("unchecked")
		List<EmployeeDTO> list = (List<EmployeeDTO>) model.get("list");

		Table table = new Table(9);
		table.setTableFitsPage(true);
		table.setPadding(1);
		table.setSpacing(1);
		
		table.addCell("First Name");
		table.addCell("Last Name");
		table.addCell("Age");
		table.addCell("Gender");
		table.addCell("Designation");
		table.addCell("Skills");
		table.addCell("DOJ");
		table.addCell("City");
		table.addCell("State");
		
		for(EmployeeDTO dto:list) {
			table.addCell(dto.getFname());
			table.addCell(dto.getLname());
			table.addCell(String.valueOf(dto.getAge()));
			table.addCell(dto.getGender());
			table.addCell(dto.getDesg());
			table.addCell(dto.getSkills());
			table.addCell(dto.getDoj());
			table.addCell(dto.getCity());
			table.addCell(dto.getState());
		}
		
		document.add(table);

	}
}
