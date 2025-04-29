package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class TestBase {
	public WebDriver driver;
	

	public WebDriver webDriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
		
		
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("QAUrl");
		
		String browser_properties = properties.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
//		Java ternary operator
		String browser = browser_maven != null ? browser_maven : browser_properties;
		if (driver == null)
		{
			if (browser.equalsIgnoreCase("chrome")) 
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver");
//				System.setProperty("webdriver.chrome.driver", "/Users/ese/Downloads/chromedriver/chromedriver");
				driver = new ChromeDriver();
			}
			if (browser.equalsIgnoreCase("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//geckodriver");
				driver = new FirefoxDriver();
			}
//			works in Selenium 4
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
			}
		
		return driver;
	}

}
