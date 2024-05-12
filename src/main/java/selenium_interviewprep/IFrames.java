package selenium_interviewprep;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrames {

	public static void main(String[] args) {

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/frames");

		WebElement frame = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame);
		WebElement text = driver.findElement(By.id("sampleHeading"));

		System.out.println(text.getText());

	}

}
