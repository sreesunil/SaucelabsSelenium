package testNG;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Utility;

public class TestDataThroughDataProvider {
	
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

	}
	
	
	@DataProvider
	public Object[][] getLoginData() throws EncryptedDocumentException, IOException {
		
		Object data [][] = Utility.getTestData("login");
		return data;
	}
	
	
	@Test(dataProvider = "getLoginData")
	public void loginData(String username , String password) {
		
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}


}
