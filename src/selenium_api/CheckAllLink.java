package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class CheckAllLink {
	WebDriver driver;
  @BeforeTest
  public void beforeTest() {
//	  System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
// 	  driver = new ChromeDriver();
	 driver = new FirefoxDriver();
		driver.get("http://gcc.global-ibk.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	  }
  @Test()//Test Script 01: Verify URL and title
  public void TC_001_Check_title() throws InterruptedException {
    String parent = driver.getWindowHandle();
	// Step 1:Check title of page is: "GOLD CHAVIT COIN"
	Assert.assertEquals(driver.getTitle(),"GOLD CHAVIT COIN");
	
   //Step 2:Click on link "Forgot password" to login page
	  driver.findElement(By.xpath("//a[contains(text(),'Forgot your password')]")).click();
	  Assert.assertEquals("http://gcc.global-ibk.com/reset-password", driver.getCurrentUrl());
	  driver.findElement(By.xpath("//span[contains(text(),'LOGIN')]//parent::div")).click(); 
 
   //Step 3:Click on "CREATE AN ACCOUNT" button to register page
	  driver.findElement(By.xpath("//a[contains(text(),'have an account yet')]")).click(); 
	  Assert.assertEquals("http://gcc.global-ibk.com/register", driver.getCurrentUrl());  
	  driver.findElement(By.xpath("//span[contains(text(),'LOGIN')]//parent::div")).click();
	  driver.navigate().refresh();
	  
	 //Check all link in footer
	  //1. Contact
	  driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click(); 
	  Assert.assertEquals("http://gcc.global-ibk.com/contact-home", driver.getCurrentUrl()); 
	  Thread.sleep(3000);
	 driver.findElement(By.xpath("//span[contains(text(),'LOGIN')]//parent::div")).click();
	  //2.Top
	  driver.findElement(By.xpath("//a[contains(text(),'Top')]")).click(); 
	  Commons.switchToChildWindow(driver,parent);
	  Assert.assertEquals("https://gold-chavit-coin.com/", driver.getCurrentUrl());
	  Commons.closeAllWithoutParentWindows(driver, parent); 
  }
  
  
 public void afterTest() {  
	 } 
 }


