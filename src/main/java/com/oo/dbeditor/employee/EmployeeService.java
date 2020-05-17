package com.oo.dbeditor.employee;

import java.util.*;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.springframework.stereotype.Service;
import org.apache.poi.common.usermodel.fonts.FontCharset;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;
	
	private final String filePath = "./";
	
	public List<Employee> getAllEmpDetails() {
		return empRepository.getEmpList(10);
	}
	
	public void addEmployee(Employee emp) {
		empRepository.save(emp);
	}
	
	public Resource loadFile(String fileName) throws MalformedURLException {
			Path fileLocation = FileSystems.getDefault().getPath(filePath, fileName);
			Resource resource;
			resource = new UrlResource(fileLocation.toUri());
			if (resource.exists()) {
				return resource;
			}
			return resource;
	}
//Text file creation
	public Object getFullTableInText() throws MalformedURLException {
//Create New File
		File tblFile = new File("Employee.txt");
		List<Employee> tblData = empRepository.findAll();
		
		try {
			FileOutputStream fop = new FileOutputStream(tblFile);
			Writer out = new OutputStreamWriter(fop, "UTF8");
			Iterator<Employee> iterateTbl = tblData.iterator();
			while (iterateTbl.hasNext()) {
				Employee emp = iterateTbl.next();
				out.write(emp.getempId()+",");
				out.write(emp.getFirstName()+",");
				out.write(emp.getLastName()+",");
				out.write(emp.getSalary()+"\n"); 
			}
			fop.close();
		} catch (IOException e) {
			System.out.println("Unable to open a new file");
			return e.getMessage();
		}  
		
		Resource resource = loadFile("Employee.txt");
		return ResponseEntity.ok()
				.contentType(MediaType.TEXT_HTML)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
		}
//Xls file creation
	public Object getFullTableInXls() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Employee");
		List<Employee> tblData = empRepository.findAll();
		int rowNo = 0;
		try {
			Iterator<Employee> iterateTbl = tblData.iterator();
			while (iterateTbl.hasNext()) {
				Employee emp = iterateTbl.next();
				Row row = sheet.createRow(rowNo++);
				row.createCell(0).setCellValue(emp.getempId());
				row.createCell(1).setCellValue(emp.getFirstName());
				row.createCell(2).setCellValue(emp.getLastName());
				row.createCell(3).setCellValue(emp.getSalary());
			}
			FileOutputStream fos = new FileOutputStream("Employee.xlsx");
			workbook.write(fos);
			workbook.close();
		} catch (IOException e) {
			e.getMessage();
		}
		Resource resource = loadFile("Employee.xlsx");
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
}
