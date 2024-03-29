package selenium_api;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TOPIC_06_INTERFACES {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;
	
  @BeforeClass
  public void beforeClass() {

	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  wait = new WebDriverWait(driver, 20);
	  action = new Actions(driver);
	  }
  public void TC_001_Move_mouse_to_element() throws InterruptedException {
	  
	  //Step 01 - Truy cập vào trang: http://www.myntra.com/
	  driver.get("http://www.myntra.com/");
	  
	  //Step 02 - Hover chuột vào Menu để login
	  action = new Actions(driver);
	  WebElement elementHover = driver.findElement(By.xpath("//div[@class='desktop-user']"));
	  WebElement SignUp = driver.findElement(By.xpath("//a[text()='login']"));
	  action.moveToElement(elementHover).perform();
	  Thread.sleep(3000);
	  
	  //Step 03 - Chọn Login button
	  Assert.assertTrue((SignUp).isDisplayed());
	  SignUp.click();
	  
	  // Step 04 - Verify Login form được hiển thị
	  Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Login to Myntra']")).isDisplayed());
  }
  public void TC_002_Click_hold_element_Select_multiple_item() {
	  driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
	  List<WebElement> listItem = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
	  wait.until(ExpectedConditions.visibilityOfAllElements(listItem));
	  action.clickAndHold(listItem.get(0)).moveToElement(listItem.get(3)).release().perform();
	
	List<WebElement> itemSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
	int numberSelected =  itemSelected.size();
	Assert.assertEquals(numberSelected,4);
	
	driver.navigate().refresh();
	
	List<WebElement> numberRandom = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
	action.keyDown(Keys.CONTROL).build().perform();
	numberRandom.get(0).click();
	numberRandom.get(3).click();
	numberRandom.get(2).click();
	numberRandom.get(5).click();
	numberRandom.get(8).click();
	action.keyUp(Keys.CONTROL).build().perform();
	
	List<WebElement> itemSelectedRan = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
	int numberSelectedRan =  itemSelectedRan.size();
	Assert.assertEquals(numberSelectedRan,5);
	
	 
  }
  public void TC_003_doubleClick() {
	  driver.get("http://www.seleniumlearn.com/double-click");
	  WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me!']"));
	  action.doubleClick(doubleClickButton).perform();
	  Alert alert = driver.switchTo().alert();
	  alert.getText();
	  Assert.assertEquals(alert.getText(),"The Button was double-clicked.");
	  alert.accept();
	  
  }
 
  public void TC_004_rightClick() {
	  driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
	  WebElement rightclickButton = driver.findElement(By.xpath("//span[text()='right click me']"));
	  action.contextClick(rightclickButton).perform();
	  action.moveToElement(driver.findElement(By.xpath("//li//span[text()='Quit']"))).perform();
	  action.click(driver.findElement(By.xpath("//li//span[text()='Quit']"))).perform();
	  Alert alert1 = driver.switchTo().alert();
	  Assert.assertEquals(alert1.getText(), "clicked: quit");
	  alert1.accept();
  }
  
  public void TC_005_DrapandDrop() throws InterruptedException {
	  driver.get("http://demos.telerik.com/kendo-ui/dragdrop/angular");
	  WebElement elementFrom = driver.findElement(By.xpath("//div[@id='draggable']"));
	  WebElement elementTo = driver.findElement(By.xpath("//div[@id='droptarget']"));
	  action.dragAndDrop(elementFrom, elementTo).perform();
	  Thread.sleep(3000);
	  WebElement message = driver.findElement(By.xpath("//div[text()='You did great!']"));
	  Assert.assertTrue(message.getText().equals("You did great!"));
  }
  @Test
  public void TC_006_Drag_Drop_HTML5_Xpath() throws AWTException, Exception {
			driver.get("https://html5demos.com/drag/");

			String oneXpath = "//a[@id='one']";
			String targetXpath = "//div[@id='bin']";
			
			drag_the_and_drop_html5_by_xpath(oneXpath, targetXpath);
			Thread.sleep(2000);
			
           drag_the_and_drop_html5_by_xpath("//a[@id='two']", "//div[@id='bin']");
		   Thread.sleep(2000);
		   
		   drag_the_and_drop_html5_by_xpath("//a[@id='three']", "//div[@id='bin']");
		   Thread.sleep(2000);
		   
		   drag_the_and_drop_html5_by_xpath("//a[@id='four']", "//div[@id='bin']");
		   Thread.sleep(2000);
		   
		   drag_the_and_drop_html5_by_xpath("//a[@id='five']", "//div[@id='bin']");
		   Thread.sleep(2000);
		   
		   drag_the_and_drop_html5_by_xpath("//a[@id='five']", "//div[@id='bin']");
		   Thread.sleep(2000);	   
			
		}
  public void drag_the_and_drop_html5_by_xpath(String sourceLocator, String targetLocator) throws AWTException {

			WebElement source = driver.findElement(By.xpath(sourceLocator));
			WebElement target = driver.findElement(By.xpath(targetLocator));

			// Setup robot
			Robot robot = new Robot();
			robot.setAutoDelay(500);

			// Get size of elements
			Dimension sourceSize = source.getSize();
			Dimension targetSize = target.getSize();

			// Get center distance
			int xCentreSource = sourceSize.width / 2;
			int yCentreSource = sourceSize.height / 2;
			int xCentreTarget = targetSize.width / 2;
			int yCentreTarget = targetSize.height / 2;

			Point sourceLocation = source.getLocation();
			Point targetLocation = target.getLocation();
			System.out.println(sourceLocation.toString());
			System.out.println(targetLocation.toString());

			// Make Mouse coordinate center of element
			sourceLocation.x += 0 + xCentreSource;
			sourceLocation.y += 70 + yCentreSource;
			targetLocation.x += 0 + xCentreTarget;
			targetLocation.y += 70 + yCentreTarget;

			System.out.println(sourceLocation.toString());
			System.out.println(targetLocation.toString());

			// Move mouse to drag from location
			robot.mouseMove(sourceLocation.x, sourceLocation.y);

			// Click and drag
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

			// Move to final position
			robot.mouseMove(targetLocation.x, targetLocation.y);

			// Drop
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
		}

  @AfterClass
  public void afterClass() {
   driver.close();
  }

}
