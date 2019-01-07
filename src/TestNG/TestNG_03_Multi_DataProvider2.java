package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNG_03_Multi_DataProvider2 {
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	  public void SetupBrowser(String browserName) {
		  System.out.println("Browser"+browserName);
		  if(browserName.equals("chrome"))
		  { 
			 System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			 driver = new ChromeDriver();
		  }
		  else if(browserName.equals("firefox"))
				  {
			  driver = new FirefoxDriver();
				  }
		  else if(browserName.equals("ie"))
		  { 
			  System.setProperty("webdriver.ie.driver", ".\\lib\\IEDriverServer.exe");
				 driver = new InternetExplorerDriver();
		  }
		  if(browserName.equals("chromeheadless"))
		  { 
			 System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			 ChromeOptions chromeOptions = new ChromeOptions();
			 chromeOptions.addArguments("---headless");
			 driver= new ChromeDriver(chromeOptions);
		  }
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		}
	@Parameters({"email","pass"})
	 @Test()
	  public void TC_01_Logintosystem(String email, String pass) {
		  driver.get("http://live.guru99.com/index.php/customer/account/login/");
		  driver.findElement(By.xpath("//input[@id='email']")).clear();
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		  driver.findElement(By.xpath("//input[@id='pass']")).clear();
		  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);
		  driver.findElement(By.xpath("//button[@title ='Login']")).click();
		  
		  Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='My Dashboard']")).isDisplayed());
		  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='box-content']/p[contains(.,'"+email+"')]")).isDisplayed());

	  }
//  //@Test(dataProvider="UserAndPassword")
//  public void TC_02_Logintosystem(String email, String pass) throws InterruptedException {
//	  driver.get("http://live.guru99.com/index.php/customer/account/login/");
//	  driver.findElement(By.xpath("//input[@id='email']")).clear();
//	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
//	  driver.findElement(By.xpath("//input[@id='pass']")).clear();
//	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);
//	  driver.findElement(By.xpath("//button[@title ='Login']")).click();
//	  
//	  Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='My Dashboard']")).isDisplayed());
//	  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='box-content']/p[contains(.,'"+email+"')]")).isDisplayed());
//
//  }
//
//  @DataProvider
//  public Object[][] UserAndPassword() {
//    return new Object[][] {
//       { "yennt.lapurema121@gmail.com", "111111"}};
//    }
  @AfterClass
  public void afterClass() {
  }

}
