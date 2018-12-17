package selenium_api;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Commons {
	public static int random() {
		  Random a = new Random();
		  int number= a.nextInt(999999);
		  return number;
	  }
	public static void clickButtonByJavaScript(WebDriver driver,WebElement element) {
		  JavascriptExecutor je = (JavascriptExecutor)driver;
		  je.executeScript("arguments[0].click();", element);	  
	  }
	  
	  public static void scrollByJavaScript(WebDriver driver, WebElement element) {
		  JavascriptExecutor je = (JavascriptExecutor)driver;
		  je.executeScript("arguments[0].scrollIntoView(true);", element);	  
	  }
	  
	  public static void switchToChildWindow(WebDriver driver, String parent) {
          Set<String> allWindows = driver.getWindowHandles();
          for (String runWindowID : allWindows) {
                      if (!runWindowID.equals(parent)) {
                                  driver.switchTo().window(runWindowID);
                                  break;
                      }
          }
}
	  public static void switchToWindowByTitle(WebDriver driver, String title) {
          Set<String> allWindows = driver.getWindowHandles();
          for (String runWindowsTitle : allWindows) {
                      driver.switchTo().window(runWindowsTitle);
                      String currentWin = driver.getTitle();
                      if (currentWin.equals(title)) {
                                  break;
                      }
          }
} 
	  public static boolean closeAllWithoutParentWindows(WebDriver driver, String parentWindow) {
          Set<String> allWindows = driver.getWindowHandles();
          for (String runWindowsTitle : allWindows) {
                      if (!runWindowsTitle.equals(parentWindow)) {
                                  driver.switchTo().window(runWindowsTitle);
                                  driver.close();
                      }
          }
          driver.switchTo().window(parentWindow);
          if (driver.getWindowHandles().size() == 1)
                     return true;
          else
                     return false;
}
	  public static void highlightElement(WebDriver driver,WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].style.border='6px groove red'", element);
	    }

	    public static Object executeForBrowser(WebDriver driver,String javaSript) {
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            return js.executeScript(javaSript);
	        } catch (Exception e) {
	            e.getMessage();
	            return null;
	        }
	    }

	    public static  Object clickToElementByJS(WebDriver driver,WebElement element) {
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            return js.executeScript("arguments[0].click();", element);
	        } catch (Exception e) {
	            e.getMessage();
	            return null;
	        }
	    }

	    public static Object sendkeyToElementByJS(WebDriver driver,WebElement element, String value) {
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            return js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	        } catch (Exception e) {
	            e.getMessage();
	            return null;
	        }
	    }

	    public static Object removeAttributeInDOM(WebDriver driver,WebElement element, String attribute) {
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	        } catch (Exception e) {
	            e.getMessage();
	            return null;
	        }
	    }

	    public static  Object scrollToBottomPage(WebDriver driver) {
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	        } catch (Exception e) {
	            e.getMessage();
	            return null;
	        }
	    }

	    public static Object navigateToUrlByJS(WebDriver driver,String url) {
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            return js.executeScript("window.location = '" + url + "'");
	        } catch (Exception e) {
	            e.getMessage();
	            return null;
	        }
	    }
}
