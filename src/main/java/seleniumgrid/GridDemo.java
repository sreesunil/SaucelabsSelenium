package seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridDemo {

	@Test
	public void parallelDemo1() throws MalformedURLException {

		DesiredCapabilities co = new DesiredCapabilities();
		co.setBrowserName("chrome");
		co.setPlatform(Platform.WINDOWS);

		WebDriver driver = new RemoteWebDriver(new URL(" http://192.168.1.167:4444"), co);
		driver.get("https://www.google.com/");

	}
	
	
    @Test
	public void parallelDemo2() throws MalformedURLException {

		DesiredCapabilities co = new DesiredCapabilities();
		co.setBrowserName("firefox");
		co.setPlatform(Platform.WINDOWS);

		WebDriver driver = new RemoteWebDriver(new URL(" http://192.168.1.167:4444"), co);
		driver.get("https://www.google.com/");

	}

}
