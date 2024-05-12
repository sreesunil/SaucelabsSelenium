package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	
	public static String FILE_PATH = ".\\datafiles\\TestDataSample.xlsx";
	
	 static Workbook book;
	 static Sheet sheet;
	
	public static  Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream(FILE_PATH);
		
		book = WorkbookFactory.create(file);
		sheet = book.getSheet(sheetName);
		
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int r=0;r<sheet.getLastRowNum();r++) {
			for(int c = 0;c<sheet.getRow(0).getLastCellNum();c++) {
				data[r][c] = sheet.getRow(r+1).getCell(c).toString();
				System.out.println(data[r][c]);
			}
		}
		
		return data;
		
		
	}

}
