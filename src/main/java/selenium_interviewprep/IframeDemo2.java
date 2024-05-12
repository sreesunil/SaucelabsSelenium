package selenium_interviewprep;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//inline frame : it is a webpage embedded in another web page or an HTML document embedded inside another HTML document.
public class IframeDemo2 {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		driver.findElement(By.id("name")).sendKeys("Hello");
		WebElement iframe1 = driver.findElement(By.id("frm1"));
		
		driver.switchTo().frame(iframe1);
		WebElement dropdown = driver.findElement(By.id("course"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Python");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).sendKeys("Hello World");
		

	}

}
