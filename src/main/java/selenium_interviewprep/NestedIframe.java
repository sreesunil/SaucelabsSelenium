package selenium_interviewprep;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframe {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		driver.get("https://leafground.com/frame.xhtml");
		
		driver.switchTo().frame(2);
		WebElement nestedFrame = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(nestedFrame);
		driver.findElement(By.id("Click")).click();
		
	}

}
