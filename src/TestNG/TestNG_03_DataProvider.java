package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNG_03_DataProvider {
	WebDriver driver;
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		}
  @Test(dataProvider="UserAndPassword")
  public void TC_01_Logintosystem(String email, String pass) throws InterruptedException {
	  driver.get("http://live.guru99.com/index.php/customer/account/login/");
	  driver.findElement(By.xpath("//input[@id='email']")).clear();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
	  driver.findElement(By.xpath("//input[@id='pass']")).clear();
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);
	  driver.findElement(By.xpath("//button[@title ='Login']")).click();
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='My Dashboard']")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='box-content']/p[contains(.,'"+email+"')]")).isDisplayed());
	  
	  driver.findElement(By.xpath("//span[@class='label'][contains(text(),'Account')]")).click();
	  driver.findElement(By.xpath("//a[@title='Log Out']")).click();
	  Thread.sleep(5000);
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'This is demo site for')]")).isDisplayed());

  }

  @DataProvider
  public Object[][] UserAndPassword() {
    return new Object[][] {
       { "yennt.lapurema121@gmail.com", "111111"},
       { "yennt.lapurema12@gmail.com", "111111" }};
    }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
