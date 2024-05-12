package selenium_interviewprep;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.XLSBUnsupportedException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebtableToExcel {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/web-table-element.php");

		List<WebElement> table = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));

		System.out.println(table.size());
		for (WebElement data : table) {

			String values = data.getText();

			System.out.println(values);
		}

		List<WebElement> name = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		for (WebElement allnames : name) {

			String companyname = allnames.getText();
			System.out.println(companyname);
		}

		//// table[@class='dataTable']/tbody/tr[2]/td[1]

		//// table[@class='dataTable']/tbody/tr/td[1]

		String beforeXpathCompany = "// table[@class='dataTable']/tbody/tr[";
		String afterxpathCompany = "]/td[1]";

		String beforexpathGroup = "// table[@class='dataTable']/tbody/tr[";
		String afterxpathGroup = "]/td[2]";

		String beforexpathPrevClose = "// table[@class='dataTable']/tbody/tr[";
		String afterxpathPrevClose = "]/td[3]";
		
		String beforexpathCurrentPrice = "// table[@class='dataTable']/tbody/tr[";
		String afterxpathCurrentPrice = "]/td[4]";
		
		String beforexpathPercentChange = "// table[@class='dataTable']/tbody/tr[";
		String afterxpathPercentChange = "]/td[5]";

		//// table[@class='dataTable']//tr

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']//tr"));

		int rowcount = rows.size();

		Xls_Reader reader = new Xls_Reader("C:\\JavaPrograms\\selenium_interviewprep\\exported_table.xlsx");
		reader.addSheet("TableData");
		reader.addColumn("TableData", "CompanyName");
		reader.addColumn("TableData", "GroupName");
		reader.addColumn("TableData", "PrevClose");
		reader.addColumn("TableData", "CurrentPrice");
		reader.addColumn("TableData", "PercentChange");
		
		
		
		
		

		for (int i = 2; i < rowcount; i++) {
			String actualxpath_company = beforeXpathCompany + i + afterxpathCompany;
			String companyname = driver.findElement(By.xpath(actualxpath_company)).getText();
			System.out.println(companyname);
			reader.setCellData("TableData", "CompanyName", i, companyname);

			String actualxpath_groups = beforexpathGroup + i + afterxpathGroup;
			String groupname = driver.findElement(By.xpath(actualxpath_groups)).getText();
			System.out.println(groupname);
			reader.setCellData("TableData", "GroupName", i, groupname);
			
			String actualxpath_PrevClose = beforexpathPrevClose  + i + afterxpathPrevClose;
			String PrevClose = driver.findElement(By.xpath(actualxpath_PrevClose)).getText();
			System.out.println(PrevClose);
			reader.setCellData("TableData", "PrevClose", i, PrevClose);
			
			String actualxpath_CurrentPrice = beforexpathCurrentPrice  + i + afterxpathCurrentPrice;
			String CurrentPrice = driver.findElement(By.xpath(actualxpath_CurrentPrice)).getText();
			System.out.println(PrevClose);
			reader.setCellData("TableData", "CurrentPrice", i, CurrentPrice);
			
			String actualxpath_PercentChange = beforexpathPercentChange  + i + afterxpathPercentChange;
			String PercentChange = driver.findElement(By.xpath(actualxpath_PercentChange)).getText();
			System.out.println(PercentChange);
			reader.setCellData("TableData", "PercentChange", i, PercentChange);

		}
		
		////table[@class='dataTable']//tr[2]
		
		List<WebElement> company = driver.findElements(By.xpath("//table[@class='dataTable']//tr[2]"));
		
		for(WebElement names : company) {
			
			String allvalues = names.getText();
			
			System.out.println(allvalues);
		}

	}

}
