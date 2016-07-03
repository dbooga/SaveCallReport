package Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CheckSave;
import pageObjects.LogIn;
import pageObjects.LogInValidate;
import pageObjects.LogOut;
import pageObjects.MassPromoCall;
import pageObjects.MassPromoCallValidate;
import pageObjects.MyAccount;
import pageObjects.MyAccountValidate;
import pageObjects.RecordCall;
import pageObjects.RecordCallValidate;
import pageObjects.Save;
import pageObjects.SaveValidate;
import pageObjects.SelectAccount;
import pageObjects.SelectAccountValidate;

public class SaveCallReport {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	// Set website
    driver = new FirefoxDriver();
    baseUrl = "https://login.salesforce.com/";
    // Puts an Implicit wait, Will wait for 15 seconds before throwing exception
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    // Launch website
    driver.navigate().to(baseUrl);
  }

  @Test(priority=0)
  public void test_Authenticate_User() throws Exception {
	// Login with credentials
	LogIn loginpage = new LogIn(driver);
	loginpage.login("bb10@bb2.com", "bugb1234");

    // Authenticate user credential after successful sign in
    LogInValidate validateUser = new LogInValidate(driver);
    assertEquals(validateUser.getUsername(), "Bas van de Kamp at BugBlitz");
  }
  
  @Test(dependsOnMethods = {"test_Authenticate_User"})
  public void test_Select_MyAccountTab() throws Exception {
	// Navigate to My Accounts tab
	MyAccount account = new MyAccount(driver);
	account.selectMyAccount();
    // Switch into Accounts iframe
    driver.switchTo().frame(driver.findElement(By.name("itarget")));
    // Verify on My Accounts page
	MyAccountValidate validateMyAccount = new MyAccountValidate(driver);
    try {
    	assertEquals(validateMyAccount.getMyAccount(), "My Accounts");
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
  }
  
  @Test(dependsOnMethods = {"test_Select_MyAccountTab"})
  public void test_Select_Account() throws Exception {
    // Select Canter, Mark from the My Accounts list
	SelectAccount saccount = new SelectAccount(driver);
	saccount.setAccount("Canter, Mark");
	saccount.selectAccount();
    // Switch to main frame
    driver.switchTo().defaultContent();
    // Verify on page Mr. Mark Canter
    SelectAccountValidate validateAccount = new SelectAccountValidate(driver);
    try {
    	assertEquals(validateAccount.getAccountName(), "Mr. Mark Canter");
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
  }
    
  @Test(dependsOnMethods = {"test_Select_Account"})
  public void test_Record_Call() throws Exception {
    // Select Record Call Button
    RecordCall recordcall = new RecordCall(driver);
    recordcall.selectRecordCall();
    // Switch into Call Report iframe
    driver.switchTo().frame(driver.findElement(By.name("itarget")));
    // Verify page is on Call Report
    RecordCallValidate validaterecord = new RecordCallValidate(driver);
    try {
    	assertEquals(validaterecord.getRecord(), "Call Report");
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
  }
  
  @Test(dependsOnMethods = {"test_Record_Call"})
  public void test_Mass_Promo_Call() throws Exception {
    // Select Mass Add Promo Call from Record Type
    MassPromoCall promocall = new MassPromoCall(driver);
    promocall.selectMassPromoCall();
    // Verify page displays New Mass Add Promo Call
    MassPromoCallValidate validatepromo = new MassPromoCallValidate(driver);
    try {
    	assertEquals(validatepromo.getPromo(), "New Mass Add Promo Call");
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
    // Select Cholecap from Detail Priority
    promocall.selectCholecap();
    // Verify Cholecap is listed under Detail Priority
    try {
      assertEquals(validatepromo.getDetail1(), "Cholecap");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Verify Cholecap is set as Product
    try {
    	String selectedOption = validatepromo.getProduct1();
        assertEquals(selectedOption, "Cholecap");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Select Labrinone from Detail Priority
    promocall.selectLabrinone();
    // Verify Labrinone is listed under Detail Priority
    try {
      assertEquals(validatepromo.getDetail2(), "Labrinone | Lab Detail Group 1");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Verify Labrinone is set as Product
    try {
    	String selectedOption = validatepromo.getProduct2();
        assertEquals(selectedOption, "Labrinone | Lab Detail Group 1");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Select Restolar Video
    promocall.selectRestolar();
    // Change Quantity to 2
    promocall.setRestolarQuantity("2");
  }
  
  @Test(dependsOnMethods = {"test_Mass_Promo_Call"})
  public void test_Save() throws Exception {
    // Click Save Button
    Save save = new Save(driver);
    save.selectSave();
    // Check saving in progress
    SaveValidate validatesave = new SaveValidate(driver);
    try {
      assertEquals(validatesave.getStatus(), "Saving");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
  
  @Test(dependsOnMethods = {"test_Save"})
  public void test_Check_Save() throws Exception {
    // Switch to main frame
    driver.switchTo().defaultContent();
    // Switch to vod iframe
    driver.switchTo().frame(driver.findElement(By.name("vod_iframe")));
    // Verify page is on Saved report
    CheckSave savecheck = new CheckSave(driver);
    try {
    	assertEquals(savecheck.getTitle(), "Mass Add Promo Call");
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
    // Verify report as status saved
    try {
      assertEquals(savecheck.getStatus(), "Saved");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Switch to main frame
    driver.switchTo().defaultContent();
  }
  
  @Test(dependsOnMethods = {"test_Check_Save"})
  public void test_Log_Out() throws Exception {
    // Log out
	LogOut logout = new LogOut(driver);
	logout.loggingout();
    // Verify page is on Sign In page
    try {
    	Thread.sleep(1500);
    	assertEquals(driver.getTitle(), "Login | Salesforce");
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    // Print any verification errors
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
