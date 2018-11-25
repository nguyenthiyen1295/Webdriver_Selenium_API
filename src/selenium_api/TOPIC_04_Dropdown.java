package selenium_api;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TOPIC_04_Dropdown {
	WebDriver driver;
	WebDriverWait waitExplicit;
	JavascriptExecutor javaExcutor;
	
	@BeforeClass
	public void beforeClass() {
	    driver = new FirefoxDriver();
	    waitExplicit = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		javaExcutor = (JavascriptExecutor) driver;
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		}
	public void TC_001_selectDropdown() throws InterruptedException {
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		
		Select select = new Select(driver.findElement(By.xpath("//select[@id='job1']")));
		
		//Step 1: Kiểm tra dropdown Job Role 01 không hỗ trợ thuộc tính multi-select
		Assert.assertFalse(select.isMultiple());
		
		//Step 2:Chọn giá trị Automation Tester trong dropdown bằng phương thức selectVisible
		select.selectByVisibleText("Automation Tester");
		Thread.sleep(3000);
		
		//Step 3: Kiểm tra giá trị đã được chọn thành công
		String a= select.getFirstSelectedOption().getText();
		System.out.println(a);
		Assert.assertEquals(a, "Automation Tester");
		
		//Step 05 - Chọn giá trị Manual Tester trong dropdown bằng phương thức selectValue
		select.selectByValue("manual");
		Thread.sleep(3000);
	
		//Step 06 - Kiểm tra giá trị đã được chọn thành công
		String b = select.getFirstSelectedOption().getText();
		Assert.assertEquals(b, "Manual Tester");
		System.out.println(b);
		
		//Step 07 - Chọn giá trị Mobile Tester trong dropdown bằng phương thức selectIndex
		select.selectByIndex(3);
		Thread.sleep(3000);
		
		//Step 08 - Kiểm tra giá trị đã được chọn thành công
		String c = select.getFirstSelectedOption().getText();
		Assert.assertEquals(c,"Mobile Tester");
		System.out.println(c);
		
		//Step 09 - Kiểm tra dropdown có đủ 5 giá trị
		List<WebElement> number = select.getOptions();
		int sl = number.size();
		System.out.println(sl);
		Assert.assertEquals(sl,5);	
	}

	public void TC_002_customDropdown() throws InterruptedException {
		
//		//Jquery
		String parent ="//span[@id='number-button']";
		String child = "//li[@class=\"ui-menu-item\"]/div";
		//Step 01 - Truy cập vào trang.
		 driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		 //chọn Item =19;
		 customDropdown("//label[text()='Select a number']",parent,child, "19");
		 Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']/span[@class ='ui-selectmenu-text'and text()='19']")).isDisplayed());
		 Thread.sleep(300);
		 
		 customDropdown("//label[text()='Select a number']",parent,child, "5");
		 Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']/span[@class ='ui-selectmenu-text'and text()='5']")).isDisplayed());
		 Thread.sleep(3000);
		 
		 customDropdown("//label[text()='Select a number']",parent,child, "12");
		 Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']/span[@class ='ui-selectmenu-text'and text()='12']")).isDisplayed());
		 Thread.sleep(300);
	 
		 //-----------------------------------------------------------------------------------------------//
//		 //Kendo UI
    	 //Step 01 - Truy cập vào trang.
		 driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		  String parent1 ="//span[@aria-owns='color_listbox']";
			String child1 = "//ul[@id='color_listbox']/li";
		 customDropdown("//h1[@id='exampleTitle']",parent1,child1, "Orange");
		 Assert.assertTrue(driver.findElement(By.xpath("//span[@aria-owns='color_listbox']//span[@class= 'k-input' and text()='Orange']")).isDisplayed());
		 Thread.sleep(300);
		 
		 customDropdown("//h1[@id='exampleTitle']",parent1,child1, "Black");
		 Assert.assertTrue(driver.findElement(By.xpath("//span[@aria-owns='color_listbox']//span[@class= 'k-input' and text()='Black']")).isDisplayed());
		 Thread.sleep(3000);
		 
		 customDropdown("//h1[@id='exampleTitle']",parent1,child1, "Grey");
		 Assert.assertTrue(driver.findElement(By.xpath("//span[@aria-owns='color_listbox']//span[@class= 'k-input' and text()='Grey']")).isDisplayed());
		 Thread.sleep(300);
		 
		 
		 //-----------------------------------------------------------------------------------------------//
		 //Angular
		   driver.get("https://material.angular.io/components/select/examples");
		    String parent2 ="//mat-select[@placeholder='State']";
			String child2 = "//mat-option[@class='mat-option ng-star-inserted']/span";
			
			customDropdown("//div[text() ='Select with reset option']",parent2,child2, "Washington");
			 Assert.assertTrue(driver.findElement(By.xpath("//mat-select[@placeholder='State']//span[text()='Washington']")).isDisplayed());
			 Thread.sleep(300);
			 
			 customDropdown("//div[text() ='Select with reset option']",parent2,child2, "New York");
			 Assert.assertTrue(driver.findElement(By.xpath("//mat-select[@placeholder='State']//span[text()='New York']")).isDisplayed());
			 Thread.sleep(300);
			 
			 customDropdown("//div[text() ='Select with reset option']",parent2,child2, "Iowa");
			 Assert.assertTrue(driver.findElement(By.xpath("//mat-select[@placeholder='State']//span[text()='Iowa']")).isDisplayed());
			 Thread.sleep(300);
			 
			 //-----------------------------------------------------------------------------------//
			 
			 driver.get("https://mikerodham.github.io/vue-dropdowns/");
			//h1[text()='vue-dropdowns']
			//li[@class='dropdown-toggle']
			//ul[@class='dropdown-menu']/li
			//div[@class='btn-group']/li[contains(text(),'First Option')]
			 customDropdown("//h1[text()='vue-dropdowns']","//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']/li", "First Option");
			 Assert.assertTrue(driver.findElement(By.xpath("//div[@class='btn-group']/li[contains(text(),'First Option')]")).isDisplayed());
			 Thread.sleep(300);
			 
			 customDropdown("//h1[text()='vue-dropdowns']","//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']/li", "Second Option");
			 Assert.assertTrue(driver.findElement(By.xpath("//div[@class='btn-group']/li[contains(text(),'Second Option')]")).isDisplayed());
			 Thread.sleep(300);
			 
			 customDropdown("//h1[text()='vue-dropdowns']","//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']/li", "Third Option");
			 Assert.assertTrue(driver.findElement(By.xpath("//div[@class='btn-group']/li[contains(text(),'Third Option')]")).isDisplayed());
			 Thread.sleep(300);
			 
			 //-----------------------------------------------------------------------------------------------------//
			////h3[text()='Effects']
			//div[@id='default-place']/input
			 driver.get("http://indrimuska.github.io/jquery-editable-select/");
			 WebElement title = driver.findElement(By.xpath("//h3[text()='Effects']"));
			 javaExcutor.executeScript("arguments[0].scrollIntoView(true)", title);
			 driver.findElement(By.xpath("//div[@id='default-place']/input")).sendKeys("Jaguar");
			 driver.findElement(By.xpath("//div[@id='default-place']/input")).sendKeys(Keys.TAB);
			 Assert.assertTrue(driver.findElement(By.xpath("//div[@id='default-place']//li[contains(@class,'selected') and text()='Jaguar']")).isDisplayed());
		     Thread.sleep(300);
		     
		     //------------------------------------------------------------------------------------------------------------------------------//
		
		    
		     
	}
	@Test
	public void TC_003_customDropdown_multleCheckbox() throws InterruptedException {
		     driver.get("http://wenzhixin.net.cn/p/multiple-select/docs/"); 
		     customDropdown2("//h2[@id='examples']","//p[@id='e1_t']//button","//p[@id='e1_t']//div[@class='ms-drop bottom']//ul//li//label");
			 Thread.sleep(300);
	}
    public void customDropdown(String eScroll,String XpathParent, String xpathChild, String expectedChild)  {
	  
		 //Step 02 - Chọn item cha
	    WebElement element = driver.findElement(By.xpath(eScroll));
	     javaExcutor.executeScript("arguments[0].scrollIntoView(true);", element);
		 driver.findElement(By.xpath(XpathParent)).click();
		 
		//Get tất cả item trong dropdown vào 1 list element (List <WebElement>)
		 List<WebElement> childList = driver.findElements(By.xpath(xpathChild));
		 waitExplicit.until(ExpectedConditions.visibilityOfAllElements(childList));
		 
		 //Dùng vòng lặp for duyệt qua từng phần tử sau đó getText
		 for(WebElement child:childList) {
			 String textItem = child.getText().trim();
			 System.out.println("Item trong list là:"+textItem);
			 
			 if(textItem.equals(expectedChild)) {
				 javaExcutor.executeScript("arguments[0].scrollIntoView(true)", child);
				 child.click();
			 break;
		 }
	}
  }
    
    public void customDropdown2(String eScroll,String XpathParent, String xpathChild)  {
  	  
		 //Step 02 - Chọn item cha
	    WebElement element = driver.findElement(By.xpath(eScroll));
	     javaExcutor.executeScript("arguments[0].scrollIntoView(true);", element);
		 driver.findElement(By.xpath(XpathParent)).click();
		 
		//Get tất cả item trong dropdown vào 1 list element (List <WebElement>)
		 List<WebElement> childList = driver.findElements(By.xpath(xpathChild));
		 childList.get(0).click();
		 waitExplicit.until(ExpectedConditions.visibilityOfAllElements(childList));
		 childList.get(1).click();
		 childList.get(2).click();
		 childList.get(4).click();
		 childList.get(6).click();
		 childList.get(7).click();
		 }
	@AfterClass
	public void afterClass() {
		//driver.close();
		
	}

}

