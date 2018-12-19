package selenium_api;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TOPIC_08_JAVASCRIPT_EXECUCTOR {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
//		driver = new ChromeDriver();
	    driver = new FirefoxDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
    public void TC_01() throws InterruptedException { 
		driver.get("http://live.guru99.com/");
	 String domainName = (String) Commons.executeForBrowser(driver,"return document.domain");
	 Assert.assertEquals(domainName,"live.guru99.com");
	 
	 String homePageUrl = (String) Commons.executeForBrowser(driver,"return document.URL");
	 System.out.println(homePageUrl);
	 Assert.assertEquals(homePageUrl,"http://live.guru99.com/");
	 
	 //Open Mobiles item
	 WebElement mobiles = driver.findElement(By.xpath("//a[text()='Mobile']"));
	 Commons.clickToElementByJS(driver, mobiles);
	 Thread.sleep(3000);
    String samsung = "//a[text()='Samsung Galaxy']//parent::h2/following-sibling::div[@class='actions']/button[@title='Add to Cart']";
    Commons.clickToElementByJS(driver, driver.findElement(By.xpath(samsung)));
    
    String textTitle = (String) Commons.executeForBrowser(driver,"return document.documentElement.innerText;");
    System.out.println(textTitle);
    Assert.assertTrue(textTitle.contains("Samsung Galaxy was added to your shopping cart."));
    Commons.scrollToBottomPage(driver);
    Thread.sleep(4000);
    WebElement policy = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
    Commons.clickToElementByJS(driver,policy);
    Commons.scrollToBottomPage(driver);
    Thread.sleep(4000);
    WebElement text =driver.findElement(By.xpath("//th[text()='WISHLIST_CNT']//following::td[text()='The number of items in your Wishlist.']"));
    Assert.assertTrue(text.isDisplayed());
    Commons.navigateToUrlByJS(driver, "http://demo.guru99.com/v4/");
    String domainName1 = (String) Commons.executeForBrowser(driver,"return document.domain");
	 Assert.assertEquals(domainName1,"demo.guru99.com");
    
	}
	
    public void TC_02() throws InterruptedException { 
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='iframeResult']")));
		WebElement lastName= driver.findElement(By.xpath("//input[@name='lname']"));
		WebElement firstName = driver.findElement(By.xpath("//input[@name='fname']"));
		WebElement submit = driver.findElement(By.xpath("//input[@value='Submit']"));
		Commons.removeAttributeInDOM(driver,lastName,"disabled");
		
	    Commons.sendkeyToElementByJS(driver, firstName, "Selenium");
	    Commons.sendkeyToElementByJS(driver, lastName, "online 07");
	    Commons.clickToElementByJS(driver, submit);
	    
	  WebElement message = driver.findElement(By.xpath("//h2[text()='Your input was received as:']//following-sibling::div[contains(text(),'fname')]"));
	  Assert.assertTrue(message.getText().contains("Selenium")&&message.getText().contains("online 07"));
	}
	
	@Test(invocationCount = 5)
    public void TC_03() throws InterruptedException { 
		 String firstname ="Selenium", midlename ="online",lastname = "007", email ="selenium_online"+Commons.random()+"@gmail.com", password ="123123";

		driver.get("http://live.guru99.com/");
		WebElement myAccount = driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']"));
		Commons.clickToElementByJS(driver, myAccount);
		Thread.sleep(3000);
		
		WebElement createAccount = driver.findElement(By.xpath("//a[@title='Create an Account']"));
		Commons.clickToElementByJS(driver, createAccount);
		Thread.sleep(3000);
        
		 WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
		 WebElement midleName = driver.findElement(By.xpath("//input[@id='middlename']"));
		 WebElement lastName = driver.findElement(By.xpath("//input[@id='lastname']"));
		 WebElement emailAdress =driver.findElement(By.xpath("//input[@id='email_address']"));
		 WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		 WebElement confirm = driver.findElement(By.xpath("//input[@id='confirmation']"));
		 WebElement checkBox = driver.findElement(By.xpath("//input[@id='is_subscribed']"));
		 WebElement register = driver.findElement(By.xpath("//span[contains(text(),'Register')]"));
		 
		 Commons.sendkeyToElementByJS(driver, firstName,firstname);
		 Commons.sendkeyToElementByJS(driver, midleName,midlename);
		 Commons.sendkeyToElementByJS(driver, lastName,lastname);
		 Commons.sendkeyToElementByJS(driver, emailAdress,email);
		 Commons.sendkeyToElementByJS(driver, passWord,password);
		 Commons.sendkeyToElementByJS(driver, confirm,password);
		 Commons.scrollToBottomPage(driver);
		 Commons.clickToElementByJS(driver, checkBox);
		 Commons.clickToElementByJS(driver, register);
		 Thread.sleep(4000);
		 
		String message = (String) Commons.executeForBrowser(driver, "return document.documentElement.innerText");
		Assert.assertTrue(message.contains("Thank you for registering with Main Website Store."));
		 
		
		 WebElement Account = driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']"));
		 WebElement logOut = driver.findElement(By.xpath("//div[@id='header-account']//a[text()='Log Out']"));
		 Commons.clickToElementByJS(driver, Account);
		 Thread.sleep(3000);
		 Commons.clickToElementByJS(driver, logOut);
		 Thread.sleep(10000);
		 
		Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'This is demo site for')]")).isDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		
	//driver.close();
	}

}
