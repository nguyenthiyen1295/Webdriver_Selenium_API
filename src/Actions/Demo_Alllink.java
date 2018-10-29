package Actions;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;				
import java.util.List;			
import org.openqa.selenium.*;		

public class Demo_Alllink {				
    		
    public static void getlink(WebDriver driver) {	
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
    }
