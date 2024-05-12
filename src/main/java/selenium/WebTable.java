package selenium;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {


		
		//https://cosmocode.io/automation-practice-webtable/
		////*[@id="countries"]//tbody/tr
		////table[@id='countries']
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		
		List<WebElement> values = driver.findElements(By.xpath("//*[@id=\"countries\"]//tbody/tr"));
		List<WebElement> tdelements = driver.findElements(By.xpath("//table[@id='countries']//tbody//tr//td"));
		
		for(WebElement elements : tdelements ) {
			
			String value = elements.getText();
			
			
			
			System.out.println(value);
		}
		/*
		 * for(WebElement tablerow : values) {
		 * 
		 * 
		 * String content = tablerow.getText();
		 * 
		 * System.out.println(content); }
		 * 
		 * System.out.println(values.size());
		 */
	}

}
