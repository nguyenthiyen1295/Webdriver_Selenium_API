package selenium_api;

import org.testng.annotations.Test;

import Actions.GeneralAction;
import Interfaces.Form_Interfaces;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Topic_02_Login {
	WebDriver driver;
  @BeforeTest
  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://live.guru99.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	  }
  @Test// Login withour Username and password
  public void TC_001_Login() {
	      GeneralAction.moveOver(driver, Form_Interfaces.btn_myAccount_Xpath);  
	      driver.findElement(By.xpath(Form_Interfaces.btn_login_Xpath)).click();
	  }
  @Test// Login withour Username and password
  public void TC_002_showError() {
	     WebElement a = driver.findElement(By.xpath(Form_Interfaces.label_errorLogin));
	     System.out.println(" Thong duoc hien thi khong "+a.isDisplayed());     
	  }
  @Test// Login without invalid email
  public void TC_003_LoginInvalidEmail() {
	  WebElement a = driver.findElement(By.xpath(Form_Interfaces.txt_email_Xpath));
	 driver.findElement(By.xpath(Form_Interfaces.txt_email_Xpath)).sendKeys("23434234@12312.123123");
	 driver.findElement(By.xpath(Form_Interfaces.btn_login_Xpath)).click();
  }
  @Test// error invalid email is shown
  public void TC_004_showError() {
	     WebElement a = driver.findElement(By.xpath(Form_Interfaces.label_errorInvalidemail));
	     System.out.println(" Hien thi thong boa loi invalid email "+a.isDisplayed());     
	  }

  @Test// Login without invalid email
  public void TC_005_LoginInvalidp_pwd() {
	  WebElement a = driver.findElement(By.xpath(Form_Interfaces.txt_email_Xpath));
	  a.clear();
	 driver.findElement(By.xpath(Form_Interfaces.txt_email_Xpath)).sendKeys("yennguyen@gmail.com");
	 driver.findElement(By.xpath(Form_Interfaces.txt_pwd_Xpath)).sendKeys("123");
	 driver.findElement(By.xpath(Form_Interfaces.btn_login_Xpath)).click();
  }
  @Test// error invalid email is shown
  public void TC_006_showErrorPwd() {
	     WebElement a = driver.findElement(By.xpath(Form_Interfaces.label_errorInvalidPwd));
	     System.out.println(" Hien thi thong boa loi invalid email "+a.isDisplayed());     
	  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
