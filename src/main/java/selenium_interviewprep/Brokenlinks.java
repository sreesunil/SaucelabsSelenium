package selenium_interviewprep;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlinks {

	public static void main(String[] args) {


		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("No of Links ---> " + links.size());
		
		List<String> urllist = new ArrayList<String>();
		
		for(WebElement link : links) {
			
			//To get the url
			String url = link.getAttribute("href");
			
			if(url==null || url.isEmpty()) {
				
				
				System.out.println("url is empty");
				
				continue;
			}
			
	
		
		try {
			
		
			HttpURLConnection httpurlconnection =(HttpURLConnection)(new URL(url).openConnection());
				
			httpurlconnection.setConnectTimeout(5000);
			httpurlconnection.connect();
			
			if(httpurlconnection.getResponseCode()>= 400) {
				
				System.out.println(url + "------> " + httpurlconnection.getResponseMessage() +httpurlconnection.getResponseCode() + " is a broken link");
				
			}
			else {
				
				System.out.println(url + "-----> " + httpurlconnection.getResponseMessage()+ " "+ httpurlconnection.getResponseCode());
			}
			
	
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();


		} catch(IOException e){
			
			e.printStackTrace();
			
		}
		
		
		
		}
		driver.quit();
		
	}
}
