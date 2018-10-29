package selenium_api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class topic_001_Check_Enviroment3 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
	    driver = new FirefoxDriver();
		driver.get("https://cybermentor.ca/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void f() {
		String title = driver.getTitle();
		System.out.println(title);
		
	}
	@Test
	public void f1() {
		String title = driver.getTitle();
		System.out.println(title);
		
	}
	@Test
	public void f2() {
		String title = driver.getTitle();
		System.out.println(title);
		
	}

	@AfterClass
	public void afterClass() {
	
	}

}
