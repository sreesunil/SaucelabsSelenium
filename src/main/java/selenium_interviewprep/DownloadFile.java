package selenium_interviewprep;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFile {

	public static void main(String[] args) {
		
	
		
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		
		String file = System.getProperty("user.dir");
		chromePrefs.put("download.default_directory",file);
		options.setExperimentalOption("prefs",chromePrefs);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		
		
		
		driver.findElement(By.linkText("Download")).click();
		
		System.out.println("File Downloaded Successfully");

	}

}
