package selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotMethod {

	public static void main(String[] args) throws IOException {


		//WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.ebay.com/deals");
		//take screenshot and store it in a file format
		File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy the screenshot to desired location using copyfile method in fileutils class
		FileUtils.copyFile(screenshotfile, new File(".//screenshot/screen.png"));
		
		System.out.println(driver.getTitle());
	}

}
