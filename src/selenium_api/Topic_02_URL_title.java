package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import Interfaces.Form_Interfaces;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Actions.GeneralAction;
import org.testng.annotations.AfterTest;

public class Topic_02_URL_title {
	WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://live.guru99.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
  }
//Test Script 01: Verify URL and title
  
  @Test//Check title of page is: "Home page"
  public void TC_001_Check_title() {
	String titlePage ="Home page";
	String actualTitle = driver.getTitle();
	Assert.assertEquals(titlePage, actualTitle);
  }
  @Test//Click on link "My Account" to login page
  public void TC_002_LoginPage() {
	  GeneralAction.moveOver(driver, Form_Interfaces.btn_myAccount_Xpath);  
	  driver.findElement(By.xpath(Form_Interfaces.btn_login_Xpath)).click();
  }
  @Test//Click on "CREATE AN ACCOUNT" button to register page
  public void TC_003_registerPage() {
	  GeneralAction.moveOver(driver, Form_Interfaces.btn_register_Xpath);  
	  driver.findElement(By.xpath(Form_Interfaces.btn_register_Xpath)).click();
  }
  @Test//Click on "CREATE AN ACCOUNT" button to register page
  public void TC_004_backPage() {
	  driver.navigate().back();  
  }
  @Test//Check url of login page
  public void TC_005_checkUrl_LoginPage() {
	  String urlPage ="http://live.guru99.com/index.php/customer/account/login/";
	  String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(urlPage, actualUrl);   
  }
  @Test// Forward to register page
  public void TC_006_forbackPage() {
	  driver.navigate().forward();  
  }
  @Test//Check url of login page
  public void TC_007_checkUrl_RegisterPage() {
	  String urlPage ="http://live.guru99.com/index.php/customer/account/create/";
	  String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(urlPage, actualUrl); 
  }
  
  
  @AfterTest
  public void afterTest() {
	  //driver.close();
  }

}
