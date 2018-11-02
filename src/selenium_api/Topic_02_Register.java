package selenium_api;

import org.testng.annotations.Test;

import Actions.GeneralAction;
import Interfaces.Form_Interfaces;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Topic_02_Register {
	WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://live.guru99.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	}
  @Test
  public void f() {
	  GeneralAction.moveOver(driver, Form_Interfaces.btn_myAccount_Xpath);  
	  GeneralAction.moveOver(driver, Form_Interfaces.btn_register_Xpath);
  }
  public void f1() {
	  
  }
  

  @AfterTest
  public void afterTest() {
  }

}
