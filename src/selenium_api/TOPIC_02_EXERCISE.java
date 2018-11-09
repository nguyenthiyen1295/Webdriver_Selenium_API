package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class TOPIC_02_EXERCISE {
	WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
 	 driver = new ChromeDriver();
	    //driver = new FirefoxDriver();
		driver.get("http://live.guru99.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	  }
  @Test//Test Script 01: Verify URL and title
  public void TC_001_Check_title() {

	// Step 1:Check title of page is: "Home page"
	Assert.assertEquals(driver.getTitle(), "Home page");
	
   //Step 2:Click on link "My Account" to login page
	  driver.findElement(By.xpath("//div[@class ='footer']//div[@class ='links']//a[text()='My Account']")).click();
 
   //Step 3:Click on "CREATE AN ACCOUNT" button to register page
	  driver.findElement(By.xpath("//a[@title='Create an Account']")).click(); 
	  
 //Step 4:Click on "CREATE AN ACCOUNT" button to register page
	  driver.navigate().back();  
	  
 //Step 5:Check url of login page
	  String urlPage ="http://live.guru99.com/index.php/customer/account/login/";
	  Assert.assertEquals(urlPage, driver.getCurrentUrl());   
 
 // Step 6:Forward to register page
	 driver.navigate().forward();  
  
  //Step 7:Check url of login page
	  String urlPage1 ="http://live.guru99.com/index.php/customer/account/create/";
		Assert.assertEquals(urlPage1, driver.getCurrentUrl()); 
  }
  
  
  @Test//Test Script 02: Login empty
  public void TC_002_Login() {
	//Step 1: Mo trang
	  	driver.get("http://live.guru99.com/");
	  	driver.findElement(By.xpath("//div[@class ='footer']//div[@class ='links']//a[text()='My Account']")).click();
	  	
   //Step 2 Login without Username and password
	  	driver.findElement(By.xpath("//button[@title='Login']")).click();
	     String a = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
	     Assert.assertEquals(a, "This is a required field.");
	    
	     String b = driver.findElement(By.xpath("//div[@id ='advice-required-entry-pass']")).getText();
	     Assert.assertEquals(b, "This is a required field.");
  }
 @Test//Test Script 03: Login invalid email.    
  public void TC_003_Logininvalidemail() {     
   //Step1 Login without invalid email
	 driver.navigate().refresh();
	 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("23434234@12312.123123");
	  
  // Step 2:click button login
	 driver.findElement(By.xpath("//button[@title ='Login']")).click();
   
   // Step 3:Error invalid email is shown
	 String c = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText();
     Assert.assertEquals(c, "Please enter a valid email address. For example johndoe@domain.com.");
	  }
  
 @Test//Test Script 04: Login with Password < 6 character
 public void TC_004_Login_Passwordlessthan6character() {     
  //Step1 Login without invalid email
	 driver.navigate().refresh();
	 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("yen@gmail.com");
	 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123");
	  
 // Step 2:click button login
	 driver.findElement(By.xpath("//button[@title ='Login']")).click();
  
  // Step 3:Error invalid email is shown
	 String c = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
     Assert.assertEquals(c, "Please enter 6 or more characters without leading or trailing spaces.");
	 
	  }
 
 @Test//Test Script 05: Login with Password incorrect
 public void TC_005_Login_Passwordincorrect() {     
  //Step1 Login without invalid email
	 driver.navigate().refresh();
	 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("yen@gmail.com");
	 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123123");
	  
  // Step 2:click button login
	 driver.findElement(By.xpath("//button[@title ='Login']")).click();
  
  // Step 3:Error invalid email is shown
	 driver.findElement(By.xpath("//span[contains(text(),'Invalid login or password.')]")).isDisplayed();
     
	 
	  }
 
 @Test//Test Script 06: Login with Password incorrect
 public void TC_006_Create_Account() {   
	 String firstname ="Selenium", midlename ="online",lastname = "007", email ="selenium_online"+random()+"@gmail.com", password ="123123";
	 
  //Step 1:Click on link "My Account" to login page
	  driver.findElement(By.xpath("//div[@class ='footer']//div[@class ='links']//a[text()='My Account']")).click();

  //Step 2:Click on "CREATE AN ACCOUNT" button to register page
	  driver.findElement(By.xpath("//a[@title='Create an Account']")).click(); 
	  
  //Step 3: Nhập thông tin cho tất cả các truong.
	  driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstname);
	  driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys(midlename);
	  driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastname);
	  driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email);
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@id='is_subscribed']")).click();
	  
	//Step 4: Click button register.
	  driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
	 
	//Step 5: Check label đăng kí thành công.
	  Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Thank you for registering with Main Website Store.')]")).isDisplayed());
	  
	 //Step 6: Logout tài khoản.
	  driver.findElement(By.xpath("//span[@class='label'][contains(text(),'Account')]")).click();
	  driver.findElement(By.xpath("//a[@title='Log Out']")).click();
	  
	 //Step 7: Check trang homepage
	  Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'This is demo site for')]")).isDisplayed());
	  
	  }

  @AfterTest
  public void afterTest() {
  } 
  public int random() {
	  Random a = new Random();
	  int number= a.nextInt(999999);
	  return number;
  }

}

