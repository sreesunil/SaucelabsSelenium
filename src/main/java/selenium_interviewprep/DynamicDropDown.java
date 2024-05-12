package selenium_interviewprep;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	//// div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79']
	// https://www.spicejet.com/

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://www.spicejet.com");

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[@class='r-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2'])[1]"))
				.click();
		int count = 0;
		String optionToSelect = "Indore";

		List<WebElement> optionlist = driver
				.findElements(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79']"));

		for (WebElement element : optionlist) {
			String city = element.getText();

			if (city.contains(optionToSelect)) {
				element.click();
				count++;
				break;
			}
		}

		if (count != 0) {

			System.out.println(optionToSelect + " has been selected");
		} else {
			System.out.println("not available in dropdown");
		}

	}

}
