package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import Interfaces.Form_Interfaces;


public class GeneralAction {
	public static void moveOver(WebDriver driver, String xpath) {
		WebElement a = driver.findElement(By.xpath(xpath));
		  Actions builder = new Actions(driver);
		// move chuột đến element đó
		  Action moveOver = builder.moveToElement(a).build();
		  moveOver.perform();
		  a.click();
	}
	
}
