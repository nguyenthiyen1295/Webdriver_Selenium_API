package selenium_api;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TOPIC_04_Textbox_textArea {
	WebDriver driver;
	String newCustomerID,newDate,newAddress, newCity, newState, newPin, newPhone, newEmail, Password;
	String editAddress, editCity, editState, editPin, editPhone, editEmail;
	By UserIbByTextbox = By.xpath("//input[@name='uid']");
	By passwordbyTextbox = By.xpath("//input[@name='password']");
	By LoginbyButton = By.xpath("//input[@name='btnLogin']");
	
	By nameByTextbox = By.xpath("//input[@name='name']");
	By dateByTextbox = By.xpath("//input[@name='dob']");
	By addressByTextbox = By.xpath("//textarea[@name='addr']");
	By cityByTextbox = By.xpath("//input[@name='city']");
	By stateByTextbox = By.xpath("//input[@name='state']");
	By pinByTextbox = By.xpath("//input[@name='pinno']");
	By phoneByTextbox = By.xpath("//input[@name='telephoneno']");
	By emailByTextbox = By.xpath("//input[@name='emailid']");
	By passwordByTextbox = By.xpath("//input[@name='password']");
	By SubmitByButton = By.xpath("//input[@value='Submit']");
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
	    //driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		newCustomerID ="Yennguyen";
		newDate = "2010-01-02";
		newAddress ="123 Address";
		newCity = "Da Nang";
		newState ="Hai chau";
		newPin = "123123";
		newPhone = "123123123";
		newEmail = "abc"+random()+"@gmail.com";
		Password ="123123";
		

		editAddress ="1234 Address";
		editCity = "Da Nang 1";
		editState ="Hai chau 1";
		editPin = "111111";
		editPhone = "321321";
		editEmail = "abc"+random()+"@gmail.com";
		}

	@Test
	public void textbox_textarea() {
		//Step 1: Login
		driver.findElement(UserIbByTextbox).sendKeys("mngr161493");
		driver.findElement(passwordbyTextbox).sendKeys("harErAh");
		driver.findElement(LoginbyButton).click();
		
		//Check login thành công.
	    WebElement a = driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
		Assert.assertTrue(a.isDisplayed());
		
		//Step 1: click button "New customer".
		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
		
		//Step 2: input data
		driver.findElement(nameByTextbox).sendKeys(newCustomerID);
		driver.findElement(dateByTextbox).sendKeys(newDate);
		driver.findElement(addressByTextbox).sendKeys(newAddress);
		driver.findElement(cityByTextbox).sendKeys(newCity);
		driver.findElement(stateByTextbox).sendKeys(newState);
		driver.findElement(pinByTextbox).sendKeys(newPin);
		driver.findElement(phoneByTextbox).sendKeys(newPhone);
		driver.findElement(emailByTextbox).sendKeys(newEmail);
		driver.findElement(passwordByTextbox).sendKeys(Password);
		driver.findElement(SubmitByButton).click();
		
		//Get text new customer ID
		String CustomerID= driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
		System.out.println("CustomerID:   "+CustomerID);
		
		//Step 3: compare data.
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), newCustomerID);
		System.out.println("New:  "+driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText());
		
		//Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), newDate);
		System.out.println("New:  "+driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText());
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), newAddress);
		System.out.println("New:  "+driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText());
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), newCity);
		System.out.println("New:  "+driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText());
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), newState);
		System.out.println("New:  "+driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText());
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), newPin);
		System.out.println("New:  "+driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText());
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), newPhone);
		System.out.println("New:  "+driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText());
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), newEmail);
		System.out.println("New:  "+driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText());
		
		//Step 4: Edit data of customer.
		//click link"edit customer".
		driver.findElement(By.xpath("//a[contains(text(),'Edit Customer')]")).click();
		
		//input- submit id
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(CustomerID);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
				
		//Step 2: Edit data
		driver.findElement(addressByTextbox).clear();
		driver.findElement(addressByTextbox).sendKeys(newAddress);
		driver.findElement(cityByTextbox).clear();
		driver.findElement(cityByTextbox).sendKeys(newCity);
		driver.findElement(stateByTextbox).clear();
		driver.findElement(stateByTextbox).sendKeys(newState);
		driver.findElement(pinByTextbox).clear();
		driver.findElement(pinByTextbox).sendKeys(newPin);
		driver.findElement(phoneByTextbox).clear();
		driver.findElement(phoneByTextbox).sendKeys(newPhone);
		driver.findElement(emailByTextbox).clear();
		driver.findElement(emailByTextbox).sendKeys(newEmail);
		driver.findElement(By.xpath("//input[@name='sub']")).click();			
	}

	@AfterClass
	public void afterClass() {
		
	
	}
	public int random() {
		Random random = new Random();
		int number= random.nextInt(999999);
		return number;
	}

}

