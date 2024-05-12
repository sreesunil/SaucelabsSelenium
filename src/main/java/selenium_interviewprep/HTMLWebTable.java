package selenium_interviewprep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLWebTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/smann/OneDrive/Desktop/link.html");
		List<WebElement> element = driver.findElements(By.xpath("//th[@scope ='row']"));
		
		System.out.println(element.size());
		
		for(WebElement elements : element) {
			
			String value = elements.getText();
			System.out.println(value);
		}
		
		List<WebElement> table = driver.findElements(By.xpath("//html/body/table/tbody/tr"));
		
		System.out.println(table.size());
		for(WebElement element1 : table) {
		
		String values = element1.getText();
		
		System.out.println(values);
		}
		
		

	}

}
