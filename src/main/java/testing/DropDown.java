package testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5));
		
		driver.get("https://trytestingthis.netlify.app/");
		WebElement dropdown = driver.findElement(By.id("option"));
		
		Select select = new Select(dropdown);
		
		select.selectByVisibleText("Option 3");
		
		List<WebElement> allElements = driver.findElements(By.id("option"));
		for(WebElement elements :allElements) {
		
		System.out.println(elements.getText());
		
		}
		
	

	}

}
