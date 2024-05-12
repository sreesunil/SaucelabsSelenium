package selenium_interviewprep;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) {
		
		//rightClickBtn
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/buttons");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		WebElement click = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		
		Actions action = new Actions(driver);
		
		action.contextClick(click).build().perform();
		
		
		
		
	}

}
