package selenium_interviewprep;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicAutoSugestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/");
		int count = 0;
		String optionToSelect = "Banjul";
		
		driver.findElement(By.id("fromCity")).sendKeys("ban");
		
		Thread.sleep(4000);
		List<WebElement> optionList = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
		
		for(WebElement element :optionList) {
			String currentOption = element.getText();
			
			if(currentOption.contains(optionToSelect)) {
				element.click();
				count++;
				break;
			}
		}
		
		if(count!=0) {
			
			System.out.println(optionToSelect + " has been selected");
		}else {
			System.out.println("not available in dropdown");
		}



	}

}


////ul[@class='react-autosuggest__suggestions-list']/li
//https://www.makemytrip.com/