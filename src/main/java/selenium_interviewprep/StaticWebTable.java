package selenium_interviewprep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/smann/OneDrive/Desktop/table.html");

		// Retrive all the data

		List<WebElement> listcontents = driver.findElements(By.name("BookTable"));

		for (WebElement content : listcontents) {

			String contents = content.getText();

			System.out.println(contents);

		}

		// Retrive specificdata

		System.out.println("--------------------------------------------");

		WebElement specificdata = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[4]"));

		System.out.println(specificdata.getText());

		// how many columns and rows

		int rows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size();
		int columns = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th")).size();

		System.out.println("number of rows " + rows);
		System.out.println("number of columns " + columns);

		System.out.println("------------------------------------------------");
		for (int r = 2; r <= rows; r++) {

			String datatext = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[" + r + "]/td[1]"))
					.getText();
			
			

			if (datatext.equals("Learn JS")) {
				System.out.println("datatext is " + datatext);
				String subject = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td[3]"))
						.getText();
				String price = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td[4]"))
						.getText();

				System.out.println(subject + "  " + price);
			}

		}

	}

}
