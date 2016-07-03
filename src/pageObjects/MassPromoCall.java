package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MassPromoCall {
	WebDriver driver;
	By promo = By.id("RecordTypeId");
	By cholecap = By.id("chkda00U0000006DoZJIA0");
	By labrinone = By.id("chkda00U000000W2Bg4IAF_a00U0000006DoZNIA0");
	By restolar = By.id("chkspa00U0000006DoVNIA0");
	By restolarquantity = By.id("qtyida00U0000006DoVNIA0");
	
	public MassPromoCall(WebDriver driver){
		this.driver = driver;
	}
	// Select Mass Promo Call
	public void selectMassPromoCall(){
		new Select(driver.findElement(promo)).selectByVisibleText("Mass Add Promo Call");
	}
	// Select Cholecap
	public void selectCholecap(){
		driver.findElement(cholecap).click();
	}
	// Select Labrinone
	public void selectLabrinone(){
		driver.findElement(labrinone).click();
	}
	// Select Restolar Video
	public void selectRestolar(){
		driver.findElement(restolar).click();
	}
	// Set Restolar Video Quantity
	public void setRestolarQuantity(String quantity){
		driver.findElement(restolarquantity).clear();
		driver.findElement(restolarquantity).sendKeys(quantity);
	}
}
