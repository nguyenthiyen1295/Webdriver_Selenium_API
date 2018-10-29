package Actions;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		
import java.util.List;		
import java.util.concurrent.TimeUnit;		
import org.openqa.selenium.*;		

public class Demo_Alllink {				
    		
    public static void main(String[] args) {	
    	//Set up environment
        String baseUrl = "http://demo.guru99.com/test/newtours/";					
        System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");					
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        String underConsTitle = "Under Construction: Mercury Tours";	
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        // Find elements link
        List<WebElement> linkElement = driver.findElements(By.tagName("a"));
        String [] linkTests = new String [(linkElement.size())];
        int i = 0;
        
         //get text link
        for(WebElement a: linkElement) {
        	
        	linkTests[i] =a.getText();
        	i++;
        }
        
        for(String t : linkTests) {
        	
        	driver.findElement(By.linkText(t)).click();
        	if (driver.getTitle().equals(underConsTitle)) {							
                System.out.println("\"" + t + "\""								
                        + " is under construction.");			
            } else {			
                System.out.println("\"" + t + "\""								
                        + " is working.");			
            }		
        driver.navigate().back();
      }
    }}
