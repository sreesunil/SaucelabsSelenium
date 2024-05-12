package selenium_interviewprep;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcel {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("EmpInfo");

		Object[][] empdata = { { "EmpId", "Name", "Job" }, { 100, "Akshay", "Project Manager" }, { 104, "Navin", "QA" },
				{ 108, "Sree", "QA" }, { 110, "Sunil", "Architect" } ,{124,"Scott","Analyst"}};

		int rows = empdata.length;
		int cols = empdata[0].length;

		System.out.println(rows);
		System.out.println(cols);
		
		
		for(int r = 0;r<rows;r++){
			
			XSSFRow row = sheet.createRow(r);
			for(int c = 0;c<cols;c++) {
				
				XSSFCell cell = row.createCell(c);
				
				Object value = empdata[r][c];
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
					
			}
			
		}
		
		String filepath = ".\\datafiles\\employee.xlsx";
		FileOutputStream outputstream = new FileOutputStream(filepath);
		workbook.write(outputstream);
		outputstream.close();
		
		System.out.println("File is created");

	}

}
