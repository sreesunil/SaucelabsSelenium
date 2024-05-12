package selenium_interviewprep;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

	WebDriver driver;
	public static final String USERNAME = "oauth-ammuedamana-4b59e";
	public static final String ACCESSKEY = "b9db3039-35a7-4e27-9ff5-cbf7a371ffe5";
	public static final String URL = "https://oauth-ammuedamana-4b59e:b9db3039-35a7-4e27-9ff5-cbf7a371ffe5@ondemand.us-west-1.saucelabs.com:443/wd/hub";

	@BeforeClass
	@Parameters("browserName")
	public void setUp(String browserName) throws MalformedURLException {

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("chromeSaucelabs")) {

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setBrowserName(browserName);
			caps.setCapability("browserName", "chrome");
			
			driver = new RemoteWebDriver(new URL(URL),caps);
		}
		
		
	}

	@Test
	public void test01() {

		driver.get("https://www.google.com/");
	}

	@Test
	public void test02() {

		driver.get("https://mail.google.com/");
	}

	 @AfterClass
	public void tearDown() {

		driver.close();

	}

}
