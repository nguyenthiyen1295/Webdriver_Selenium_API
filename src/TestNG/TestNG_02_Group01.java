package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_02_Group01 {
  @Test(groups="Actions")
  public void TC_01() {  
}
  
  @Test(groups="Actions")
  public void TC_02() {  
}
  @Test(groups="Interfaces")
  public void TC_03() {  
  }
  @Test(groups="Interfaces")
  public void TC_04() {  
  }
  @Test(groups="Actions")
  public void TC_05() {  
  }
  @Test(groups="Interfaces")
  public void TC_06() {  
  }
  @Test(groups="Actions")
  public void TC_07() {  
  }
  @Test(groups="Actions")
  public void TC_08() {  
  }

}