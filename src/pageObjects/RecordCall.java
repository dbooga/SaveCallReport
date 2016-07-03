package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RecordCall {
	WebDriver driver;
	By record = By.name("record_a_call");
	
	public RecordCall(WebDriver driver){
		this.driver = driver;
	}
	// Select Record Call Button
	public void selectRecordCall(){
		driver.findElement(record).click(); // Set focus
		driver.findElement(record).sendKeys(Keys.ENTER); 
	}
}
