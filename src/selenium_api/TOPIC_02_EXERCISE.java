package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class TOPIC_02_EXERCISE {
	WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	    driver = new FirefoxDriver();
		driver.get("http://live.guru99.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	  }
  @Test//Test Script 01: Verify URL and title
  public void TC_001_Check_title() {

	//Check title of page is: "Home page"
	Assert.assertEquals(driver.getTitle(), "Home page");
	
   //Click on link "My Account" to login page
	  driver.findElement(By.xpath("//div[@class ='footer']//div[@class ='links']//a[text()='My Account']")).click();
 
   //Click on "CREATE AN ACCOUNT" button to register page
	  driver.findElement(By.xpath("//a[@title='Create an Account']")).click(); 
	  
 //Click on "CREATE AN ACCOUNT" button to register page
	  driver.navigate().back();  
	  
 //Check url of login page
	  String urlPage ="http://live.guru99.com/index.php/customer/account/login/";
	  Assert.assertEquals(urlPage, driver.getCurrentUrl());   
 
 // Forward to register page
	 driver.navigate().forward();  
  
  //Check url of login page
	  String urlPage1 ="http://live.guru99.com/index.php/customer/account/create/";
		Assert.assertEquals(urlPage1, driver.getCurrentUrl()); 
  }
  
  
  @Test//Test Script 02: Login empty
  public void TC_002_Login() {
	//Step 1: Mở trang chính
	  	driver.get("http://live.guru99.com/");
	  	driver.findElement(By.xpath("//div[@class ='footer']//div[@class ='links']//a[text()='My Account']")).click();
	  	
   //Step 2 Login without Username and password
	     String a = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
	     Assert.assertEquals(a, "This is a required field.");
	    
	     String b = driver.findElement(By.xpath("//div[@id ='advice-validate-password-pass']")).getText();
	     Assert.assertEquals(b, "This is a required field.");
   //Step 3 Login without invalid email
	 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("23434234@12312.123123");
	 driver.findElement(By.xpath("//button[@title ='Login']")).click();
   
   // error invalid email is shown
	 String c = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
     Assert.assertEquals(c, "Please enter a valid email address. For example johndoe@domain.com.");
	  }
  
   

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
