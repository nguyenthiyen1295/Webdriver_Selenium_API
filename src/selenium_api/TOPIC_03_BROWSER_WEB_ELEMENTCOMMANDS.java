package selenium_api;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TOPIC_03_BROWSER_WEB_ELEMENTCOMMANDS {
	WebDriver driver;
	By email = By.xpath("//input[@id='mail']");
	By age = By.xpath("//input[@id='under_18']");
	By education = By.xpath("//textarea[@id='edu']");
	By job = By.xpath("//select[@id='job1']");
	By interested = By.xpath("//input[@id='development']");
	By slide = By.xpath("//input[@id='slider-1']");
	By button = By.xpath("//button[@id='button-enabled']");
	By password_disable = By.xpath("//input[@id='password']");
	By radiobutton_disable = By.xpath("//input[@id='radio-disabled']");
	By biography_disable = By.xpath("//textarea[@id='bio']");
	By checkbox_interested_disable = By.xpath("//input[@id='check-disbaled']");
	By job2_disable = By.xpath("//select[@id='job2']");
	By Slide_disable = By.xpath("//input[@id='slider-2']");
	By button_disable = By.xpath("//button[@id='button-disabled']");
	
@BeforeTest
 public void beforeTest() {
	 System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
	 driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://daominhdam.github.io/basic-form/index.html");
	
	}
  @Test// Script 01: Kiểm tra phần tử hiển thị trên trang
  public void TC_001_CheckelementisDisplayed() {
  //Step 1: Check email --send email
    if(driver.findElement(email).isDisplayed())
	driver.findElement(email).sendKeys("Automation test");
  //Step 2: Check education --send education
    if(driver.findElement(education).isDisplayed())
    driver.findElement(education).sendKeys("Automation test");
  //Step 3: Check age--click
    if(driver.findElement(age).isDisplayed())
    	driver.findElement(age).click();
   }

@Test// Test Script 02: Kiểm tra phần tử enable/ disable trên trang
  public void TC_002_CheckelementisDisable_Enable() {
	 //Element enable
	  Assert.assertTrue(enable(age));
	  Assert.assertTrue(enable(email));
	  Assert.assertTrue(enable(education));
	  Assert.assertTrue(enable(job));
	  Assert.assertTrue(enable(interested));
	  Assert.assertTrue(enable(slide));
	  Assert.assertTrue(enable(button));
	  
	//Element disable
	  Assert.assertFalse(enable(password_disable));
	  Assert.assertFalse(enable(radiobutton_disable));
	  Assert.assertFalse(enable(biography_disable));
	  Assert.assertFalse(enable(checkbox_interested_disable));
	  Assert.assertFalse(enable(job2_disable));
	  Assert.assertFalse(enable(Slide_disable));
	  Assert.assertFalse(enable(button_disable));
	  
  }
@Test// Test Script 03: Test Script 03: Kiểm tra phần tử được chọn trên trang

public void TC_003_CheckelementisSelected() {
	if(!driver.findElement(age).isSelected())
    	driver.findElement(age).click();
	else 
		System.out.println("tuoi đã dc chon");
	if(!driver.findElement(interested).isSelected())
    	driver.findElement(interested).click();
	else 
		System.out.println("Development đã dc chon");
}
  @AfterTest
  public void afterTest() {
  }
 public boolean enable(By by) {
	 WebElement a = driver.findElement(by);
	 if(a.isEnabled()) {
		 System.out.println("Element"+by+"is enable.");
	     return true;}
	 else
      {
		 System.out.println("Element"+by+"is disable.");
	     return false;
      }
  }
}