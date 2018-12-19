package selenium_api;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import selenium_api.Commons;

public class TOPIC_05_BUTTON_RADIOBUTTON_CHECKBOX_ALERT {
	WebDriver driver;
	
  @BeforeClass
  public void beforeClass() {

	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  }

  public void TC_001_clickButton() {	
	  driver.get(" http://live.guru99.com/");
	  WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]"));
	 
	 
	  //click by Seleniium
	  //myAccount.click();
	  
	  //ClickByJavaScript
	  Commons.clickButtonByJavaScript(driver,myAccount);
	  Assert.assertEquals(driver.getTitle(), "Customer Login");
	  WebElement createAccount = driver.findElement(By.xpath("//a[@title='Create an Account']"));
	  
	  //click create account
	  Commons.clickButtonByJavaScript(driver,createAccount);
      Assert.assertEquals(driver.getCurrentUrl(),"http://live.guru99.com/index.php/customer/account/create/");
  }

  public void TC_002_clickCheckBox() throws InterruptedException {
	  driver.get("https://demos.telerik.com/kendo-ui/styling/checkboxes");
	  WebElement dozonCheckbox = driver.findElement(By.xpath("//label[contains(text(),'Dual-zone air conditioning')]//preceding-sibling::input"));
	  Commons.clickButtonByJavaScript(driver,dozonCheckbox);
	  Thread.sleep(3000);
	  Commons.clickButtonByJavaScript(driver,dozonCheckbox);
  }
  
   public void TC_003_clickRadioButton() throws InterruptedException {
	  driver.get("http://demos.telerik.com/kendo-ui/styling/radios");
	WebElement radioItem = driver.findElement(By.xpath("//label[contains(text(),'2.0 Petrol, 147kW')]//preceding-sibling::input"));
	if(!radioItem.isSelected()) {
		Commons.clickButtonByJavaScript(driver,radioItem);
	}
	Assert.assertTrue(radioItem.isSelected());
	//unclick
	Commons.clickButtonByJavaScript(driver,radioItem);
	}
  
  public void TC_004_jsAlert() throws InterruptedException {
	  driver.get("https://daominhdam.github.io/basic-form/index.html"); 
	  WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
	  Commons.clickButtonByJavaScript(driver,jsAlert);
	  Alert alert = driver.switchTo().alert();
	  Assert.assertEquals(alert.getText(), "I am a JS Alert");
	  Thread.sleep(3000);
	  alert.accept();
	  Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'You clicked an alert successfully ')]")).isDisplayed());
	   }
  
  
  public void TC_005_jsAlertCancel() throws InterruptedException {
	  driver.get("https://daominhdam.github.io/basic-form/index.html"); 
	  WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
	  Commons.clickButtonByJavaScript(driver,jsAlert);
	  Alert alert = driver.switchTo().alert();
	  Assert.assertEquals(alert.getText(), "I am a JS Confirm");
	  Thread.sleep(3000);
	  alert.dismiss();
	  Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'You clicked: Cancel')]")).isDisplayed());
	   }
  
  @Test
  public void TC_006_jsPrompt() throws InterruptedException {
	  driver.get("https://daominhdam.github.io/basic-form/index.html"); 
	  Commons.scrollByJavaScript(driver,driver.findElement(By.xpath("//a[contains(text(),'Hover over me')]")));
	  WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
	  Commons.clickButtonByJavaScript(driver,jsAlert);
	  Alert alert = driver.switchTo().alert();
	  String name = "yennguyen";
	  alert.sendKeys(name);
	  Thread.sleep(3000);
	  alert.accept();
	  Thread.sleep(3000);
	  WebElement message = driver.findElement(By.xpath("//p[contains(text(),'You entered: ')]"));
	  Assert.assertEquals(message.getText(),"You entered: "+name);
	   }
  @AfterClass
  public void afterClass() {
  }
  
  
}
