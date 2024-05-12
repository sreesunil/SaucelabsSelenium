package selenium_interviewprep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
 
		driver.findElement(By.id("uploadFile")).sendKeys("C:\\JavaPrograms\\selenium_interviewprep\\src\\main\\resources\\File\\Tulip.jpg");
		
		
		System.out.println("File Uploaded successfully");


	}

}

