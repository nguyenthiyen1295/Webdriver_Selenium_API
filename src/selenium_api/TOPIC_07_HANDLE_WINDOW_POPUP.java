package selenium_api;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TOPIC_07_HANDLE_WINDOW_POPUP {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
	    driver = new FirefoxDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

    public void TC_01_Iframe() throws InterruptedException { 
		//Step 1:
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		
		//Step 2:
		Commons.scrollByJavaScript(driver,driver.findElement(By.xpath("//legend[text()='Table']")));
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Thread.sleep(3000); 
		
		//Step 3:
		String Parent = driver.getWindowHandle();
		Commons.switchToChildWindow(driver, Parent);
		Thread.sleep(3000);
		
	    //Step 4:
		Assert.assertEquals(driver.getTitle(), "Google");
		Thread.sleep(3000);
		
		//step 6:
		Commons.switchToWindowByTitle(driver,"SELENIUM WEBDRIVER FORM DEMO");
		Assert.assertEquals(driver.getTitle(),"SELENIUM WEBDRIVER FORM DEMO");
	}
    public void TC_02_Window_hdfcbank() throws InterruptedException { 
		driver.get("http://www.hdfcbank.com/");
		String Parent = driver.getWindowHandle();
		// Close popup 
		List<WebElement> iframe = driver.findElements(By.xpath("//iframe[@id='vizury-notification-template']"));
		System.out.println(iframe.size());
		if(iframe.size()>0) {
		   driver.switchTo().frame(iframe.get(0));
			Commons.clickButtonByJavaScript(driver,driver.findElement(By.cssSelector("#div-close")));
	}
		//Swith to new window
		driver.findElement(By.xpath("//a[text()='Agri']")).click();
		Commons.switchToChildWindow(driver, Parent);
		Assert.assertEquals(driver.getTitle().trim(), "HDFC Bank Kisan Dhan Vikas e-Kendra");
		Thread.sleep(3000);
		//Click Detail
		Commons.clickButtonByJavaScript(driver, driver.findElement(By.xpath("//a[contains(.,'Account Details')]")));
		Commons.switchToWindowByTitle(driver, "Welcome to HDFC Bank NetBanking");
		Assert.assertEquals(driver.getTitle(), "Welcome to HDFC Bank NetBanking");
		Thread.sleep(3000);
		
		//click Policy
		WebElement policy = driver.findElement(By.xpath("//frame[@name='footer']"));
		driver.switchTo().frame(policy);
		Commons.clickButtonByJavaScript(driver, driver.findElement(By.xpath("//p[@class='footer']//a[contains(text(),'Privacy Policy')]")));
		driver.manage().window().maximize();
		Commons.switchToWindowByTitle(driver, "HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");
		Assert.assertEquals(driver.getTitle().trim(),"HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");
		
		//click CSR
		Commons.clickButtonByJavaScript(driver, driver.findElement(By.xpath("//a[@title='Corporate Social Responsibility']")));
		Assert.assertEquals(driver.getTitle().trim(), "HDFC BANK - CSR - Homepage");
		Thread.sleep(5000);
		
		//close alltabwithoutparent
		Commons.closeAllWithoutParentWindows(driver, Parent);
		
	}  
	@Test
    public void TC_03_Window_guru99() throws InterruptedException { 
		driver.get(" http://live.guru99.com/index.php/");
		String Parent = driver.getWindowHandle();
		Actions  action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Mobile']"))).perform();
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		
		String xparia = "//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']";
		String Samsung = "//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']";
		driver.findElement(By.xpath(xparia)).click();
		driver.findElement(By.xpath(Samsung)).click();
		action.moveToElement(driver.findElement(By.xpath("//div[@class='actions']//span[text()='Compare']"))).perform();
		driver.findElement(By.xpath("//div[@class='actions']//span[text()='Compare']")).click();
		Commons.switchToChildWindow(driver, Parent);
		Assert.assertEquals(driver.getTitle(),"Products Comparison List - Magento Commerce");
		Commons.closeAllWithoutParentWindows(driver, Parent);
	}
    @AfterClass
	public void afterClass() {
    	
	
	}


}
