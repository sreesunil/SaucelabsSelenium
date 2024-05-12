package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGAnnotations {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

	}

	@Test
	public void TC01() {
		
		String title = driver.getTitle();

		System.out.println(title);

	}


	@Test
	public void TC03() {

		boolean b = driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();

		System.out.println(b);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
