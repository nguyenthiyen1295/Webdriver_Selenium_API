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

public class TestNG_02_Group {
  @Test(groups="Actions")
  public void TC_01_Create() {  
}
  
  @Test(groups="Actions")
  public void TC_02_Edit() {  
}
  @Test(groups="Interfaces")
  public void TC_03_Update() {  
  }
  @Test(groups="Interfaces")
  public void TC_04_Assigned() {  
  }
  @Test(groups="Actions")
  public void TC_05_Deleted() {  
  }
  @Test(groups="Interfaces")
  public void TC_06_update_2() {  
  }
  @Test(groups="Actions")
  public void TC_07_Createed_2() {  
  }
  @Test(groups="Actions")
  public void TC_08_Createed_2() {  
  }

}