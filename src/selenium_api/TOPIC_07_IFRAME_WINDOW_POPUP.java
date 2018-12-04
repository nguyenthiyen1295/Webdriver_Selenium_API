package selenium_api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TOPIC_07_IFRAME_WINDOW_POPUP {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
	    driver = new FirefoxDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@Test
    public void TC_01() { 
		driver.get("https://www.hdfcbank.com/");
		
		//Isusse1: Check element không displayed.
		List<WebElement> iframe = driver.findElements(By.xpath("//iframe[@id='vizury-notification-template']"));
		System.out.println(iframe.size());
		if(iframe.size()>0) {
			driver.switchTo().frame(iframe.get(0));
			clickButtonByJavaScript(driver.findElement(By.cssSelector("#div-close")));
			System.out.println("Close successfully");
			
			// Issuse 03: Swith về lại trang parent để lấy element.
		driver.switchTo().defaultContent();
		}
		//issuse 02:IDfram random id thì bắt buộc phải lấy từ element parent.
		
		WebElement lookFor = driver.findElement(By.xpath("//div[@class='flipBannerWrap']//iframe"));
		driver.switchTo().frame(lookFor);
		String  message = driver.findElement(By.xpath("//span[@id='messageText']")).getText();
		Assert.assertEquals(message,"What are you looking for?");
	//
	driver.switchTo().defaultContent();
	WebElement slidingFrame = driver.findElement(By.xpath("//div[@class='slidingbanners']//iframe"));
	driver.switchTo().frame(slidingFrame);
	
	List<WebElement> slideIMG = driver.findElements(By.xpath("//div[@id='bannercontainer']//img"));
	int sizeIMG = slideIMG.size();
	Assert.assertEquals(sizeIMG, 6);
	
	//check 8 item
	driver.switchTo().defaultContent();
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='flipBannerWrap']")).isDisplayed());

	List<WebElement> listItemFrame = driver.findElements(By.xpath("//div[@class='flipBannerWrap']//img[@class='front icon']"));
	Assert.assertEquals(listItemFrame.size(), 8);
	//check img is displayed
	for(WebElement item:listItemFrame) {
		Assert.assertTrue(item.isDisplayed());
		System.out.println(item.isDisplayed());
	}

	}
	@AfterClass
	public void afterClass() {
	
	}
	public void clickButtonByJavaScript(WebElement element) {
		  JavascriptExecutor je = (JavascriptExecutor)driver;
		  je.executeScript("arguments[0].click();", element);	  
	  }

}
