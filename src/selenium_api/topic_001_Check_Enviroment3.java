package selenium_api;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Actions.Demo_Alllink;

public class topic_001_Check_Enviroment3 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {					
		System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");					
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	@Test
	public void f() {
		Demo_Alllink.getlink(driver);
	}

	@AfterClass
	public void afterClass() {
	
	}

}
