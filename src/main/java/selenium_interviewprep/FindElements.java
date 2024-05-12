package selenium_interviewprep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElements {

	@Test
	public void findElements() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");

		List<WebElement> elements = driver.findElements(By.tagName("button"));
		System.out.println(elements.size());
		for (WebElement element : elements) {
			System.out.println(element.getText());

		}
	}

}
