package selenium_api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Actions.Demo_Alllink;

public class topic_001_Check_Enviroment3 {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");					
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void f() {
		List<WebElement> linkElement = driver.findElements(By.tagName("a"));
        String [] linkTests = new String [(linkElement.size())];
        int i = 0;
        
         //get text link
        for(WebElement a: linkElement) {
        	
        	linkTests[i] =a.getText();
        	i++;
        }
        //each of link.
        for(String t : linkTests) {
        	
        	driver.findElement(By.linkText(t)).click();			
                System.out.println("\"" + t + "\""								
                        + " is working.");			
            }		
        driver.navigate().back();
		
	}

	@AfterClass
	public void afterClass() {
	
	}

}

