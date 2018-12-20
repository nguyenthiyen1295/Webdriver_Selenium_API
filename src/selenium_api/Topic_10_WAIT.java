package selenium_api;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_WAIT {
	WebDriver driver;
	WebDriverWait waitExplicit;
	Date date;
	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
//		driver = new ChromeDriver();
        driver = new FirefoxDriver();
		driver.manage().window().maximize();
		waitExplicit = new WebDriverWait(driver, 30);
	}
	
    public void TC_01_Implicit_Wait() { 
		//Step 1
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		//step 2
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button[text()='Start']"));
		startButton.click();
		//check text is showed.
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());	
	}
	public void TC_02_Explicit_Wait() {
       
    	driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		//step 2
		WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button[text()='Start']"));
		startButton.click();
		By loading = By.xpath("//div[@id='loading']");
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(loading)); 
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());	
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(loading));
	}
	public void TC_03_Explicit_Wait_Presend() {
       
    	driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
    	
		//step 2
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button[text()='Start']"));
		startButton.click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());		
	}
    @Test
   	public void TC_04_Explicit_Wait_Presend() { 
       	driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
  		//step 2
       	System.out.println(" ...........................Start time:.............................");
       	System.out.println(date =new Date());
       	//check invisible --- không có trong DOM
       	waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
       	System.out.println("........................End time...........................");
       	System.out.println(date = new Date());
       	
       	//Click button start
       	 WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button[text()='Start']"));
   		startButton.click();
   		
   		// Check label "hello Word được được visible trong DOM chưa và được hiển thị trên UI.
   		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
   		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
   		
       	//check invisible Loading in DOM
   		System.out.println(" ...........................Start time:.............................");
       	System.out.println(date =new Date());
       	waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
       	System.out.println("........................End time...........................");
       	System.out.println(date = new Date());
       	
   		
   		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
   		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());	
   	}
    
	@AfterClass
	public void afterClass() {
		
	//driver.close();
	}

}
