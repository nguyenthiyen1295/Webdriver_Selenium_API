package selenium_api;

import org.testng.annotations.Test;

import Actions.GeneralAction;
import Interfaces.Form_Interfaces;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
  }
  @Test//Click on "CREATE AN ACCOUNT" button to register page
  public void TC_003_registerPage() {
	  GeneralAction.moveOver(driver, Form_Interfaces.btn_register_Xpath);  
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
  
  //Test Script 02: Login 
  @Test// Login without Username and password
  public void TC_008_Login() {
	  	  driver.get("http://live.guru99.com/");
	      GeneralAction.moveOver(driver, Form_Interfaces.btn_myAccount_Xpath);  
	      driver.findElement(By.xpath(Form_Interfaces.btn_login_Xpath)).click();
	  }
  @Test// Login withour Username and password
  public void TC_009_showError() {
	     WebElement a = driver.findElement(By.xpath(Form_Interfaces.label_errorLogin));
	     System.out.println(" Thong duoc hien thi khong "+a.isDisplayed());     
	  }
  @Test// Login without invalid email
  public void TC_010_LoginInvalidEmail() {
	 // WebElement a = driver.findElement(By.xpath(Form_Interfaces.txt_email_Xpath));
	 driver.findElement(By.xpath(Form_Interfaces.txt_email_Xpath)).sendKeys("23434234@12312.123123");
	 driver.findElement(By.xpath(Form_Interfaces.btn_login_Xpath)).click();
  }
  @Test// error invalid email is shown
  public void TC_011_showError() {
	     WebElement a = driver.findElement(By.xpath(Form_Interfaces.label_errorInvalidemail));
	     System.out.println(" Hien thi thong boa loi invalid email "+a.isDisplayed());     
	  }

  @Test// Login without invalid email
  public void TC_012_LoginInvalidp_pwd() {
	  WebElement a = driver.findElement(By.xpath(Form_Interfaces.txt_email_Xpath));
	  a.clear();
	 driver.findElement(By.xpath(Form_Interfaces.txt_email_Xpath)).sendKeys("yennguyen@gmail.com");
	 driver.findElement(By.xpath(Form_Interfaces.txt_pwd_Xpath)).sendKeys("123");
	 driver.findElement(By.xpath(Form_Interfaces.btn_login_Xpath)).click();
  }
  @Test// error invalid email is shown
  public void TC_013_showErrorPwd() {
	     WebElement a = driver.findElement(By.xpath(Form_Interfaces.label_errorInvalidPwd));
	     System.out.println(" Hien thi thong boa loi invalid email "+a.isDisplayed());     
	  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
