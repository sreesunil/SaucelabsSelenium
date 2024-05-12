package selenium_interviewprep;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrameDemo {

	public static void main(String[] args) {


		
		//https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit
		
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		
		 WebElement frame = driver.findElement(By.id("iframeResult"));
		 
		 driver.switchTo().frame(frame);
		 
		 driver.findElement(By.id("fname")).sendKeys("Sree");
		 driver.findElement(By.id("lname")).sendKeys("Deozz");
		 driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
	}

}
