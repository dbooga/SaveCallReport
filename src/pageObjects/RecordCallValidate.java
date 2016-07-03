package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecordCallValidate {
	WebDriver driver;
	By record = By.cssSelector("h1.pageType");
	
	public RecordCallValidate(WebDriver driver){
		this.driver = driver;
	}
	// Grab Record report
	public String getRecord(){
		return driver.findElement(record).getText();
	}
}
