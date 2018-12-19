package selenium_api;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TOPIC_09_UPLOADFILE {
	WebDriver driver;
	
	String rootFolder = System.getProperty("user.dir");
	String img1 = "1.jpg";
	String img2 = "2.jpg";
	String img3 = "3.jpg";
	String filePathName1 = rootFolder+"\\UploadFile\\"+ img1;
	String filePathName2 = rootFolder+"\\UploadFile\\"+ img2;
	String filePathName3 = rootFolder+"\\UploadFile\\"+ img3;

	@BeforeClass
	public void beforeClass() {
		//1. Chạy pass trên chrome.
//			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
//			driver = new ChromeDriver();
		
		//2. chạy pass trên firefox.
//		  System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");
//	      driver = new FirefoxDriver();
        /* chạy trên IE*/
		 System.setProperty("webdriver.ie.driver", ".\\lib\\IEDriverServer.exe");
	      driver = new InternetExplorerDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
    public void TC_01_SingleFile() throws InterruptedException { 
	   driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		WebElement upload = driver.findElement(By.xpath("//input[@name='files[]']"));
		//upload.sendKeys(filePathName1);
		//Thread.sleep(3000);
    }	
	public void TC_02_MulitiFile() throws InterruptedException {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		WebElement upload = driver.findElement(By.xpath("//input[@name='files[]']"));
		upload.sendKeys(filePathName1+"\n"+filePathName2+"\n"+filePathName3);
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//tr[@class='template-upload fade in']//p[@class='name' and text()='1.jpg']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//tr[@class='template-upload fade in']//p[@class='name' and text()='2.jpg']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//tr[@class='template-upload fade in']//p[@class='name' and text()='3.jpg']")).isDisplayed());
		Thread.sleep(4000);
		Commons.scrollToBottomPage(driver);
		
		List<WebElement> startButton= driver.findElements(By.xpath("//table[@class='table table-striped']//button[@class='btn btn-primary start']"));
		
		for(WebElement a:startButton) {
			a.click();
			Thread.sleep(3000);
		}	
	}
    public void TC_03_AutoIT() throws InterruptedException, Exception { 
	   driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		Thread.sleep(3000);
		//click to add file button.
		if(driver.toString().toLowerCase().contains("chrome")){
				driver.findElement(By.cssSelector(".fileinput-button")).click();
				}
		else if(driver.toString().toLowerCase().contains("firefox")) {
		       Commons.clickToElementByJS(driver, driver.findElement(By.xpath("//input[@name='files[]']")));
		}else
		{
            driver.findElement(By.xpath("//span[contains(text(),'Add files')]")).click();
            }
		
		//executor file exe
		if(driver.toString().toLowerCase().contains("chrome")) {
			Runtime.getRuntime().exec(new String[] {".\\UploadFile\\chrome.exe", filePathName1});}
		else if(driver.toString().toLowerCase().contains("firefox")) {
				Runtime.getRuntime().exec(new String[] {".\\UploadFile\\firefox.exe", filePathName1});
		}
		else {Runtime.getRuntime().exec(new String[] {".\\UploadFile\\ie.exe", filePathName1});};
 }
 @Test()
    public void TC_03_rebot() throws InterruptedException, Exception { 	
	 driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		Thread.sleep(3000);
	//Specify the file location with extension
	 StringSelection select = new StringSelection(filePathName1);

	 //Copy to clipboard
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

	 //Click
	 if(driver.toString().toLowerCase().contains("chrome")){
			driver.findElement(By.cssSelector(".fileinput-button")).click();
			}
	else if(driver.toString().toLowerCase().contains("firefox")) {
	       Commons.clickToElementByJS(driver, driver.findElement(By.xpath("//input[@name='files[]']")));
	}else
	{
     driver.findElement(By.xpath("//span[contains(text(),'Add files')]")).click();
     }
	 
	 Thread.sleep(5000);

	 Robot robot = new Robot();
	 Thread.sleep(1000);

	 robot.keyPress(KeyEvent.VK_ENTER);
	 robot.keyRelease(KeyEvent.VK_ENTER);

	 robot.keyPress(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_V);

	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 robot.keyRelease(KeyEvent.VK_V);
	 Thread.sleep(1000);

	 robot.keyPress(KeyEvent.VK_ENTER);
	 robot.keyRelease(KeyEvent.VK_ENTER);
 }

 @AfterClass
	public void afterClass() {

	
	}

}
