package selenium_interviewprep;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	
	public static void main(String [] args) throws IOException {
		
		String path = ".\\datafiles\\TestData.xlsx";
		
		//to read the data 
		FileInputStream inputstream = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		
		XSSFSheet sheet = workbook.getSheet("TestData");
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		for(int r =0;r<rows;r++) {
			
			XSSFRow row = sheet.getRow(r);
			for(int c = 0;c<cols;c++) {
				XSSFCell cell = row.getCell(c);
				
				switch(cell.getCellType()) {
				case STRING:
				System.out.print(cell.getStringCellValue());
				break;
				
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
					
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				
				
				}
				System.out.print(" | ");
			}
			
			System.out.println();
			
		}
		
		
	}

}

