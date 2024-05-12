package selenium_interviewprep;

import java.time.Duration;
import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://omayo.blogspot.com/");
		String url = driver.getCurrentUrl();
		System.out.println(url);
	
		
		driver.findElement(By.id("selenium143")).click();
	
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator it = handles.iterator();
		String parentID = (String) it.next();
		String childID = (String) it.next();
		
		
			driver.switchTo().window(childID);
			
			System.out.println("Testing*******");
			
		
				driver.findElement(By.linkText("What is Java ?")).click();
				
				System.out.println("Hello Hello******");
				
			
			
		}
		 
		
	}


