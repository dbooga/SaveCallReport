package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckSave {
	WebDriver driver;
	By titlereport = By.cssSelector("h2.mainTitle");
	By status = By.id("dat_Status_vod__c");
	
	public CheckSave(WebDriver driver){
		this.driver = driver;
	}
	// Grab title report
	public String getTitle(){
		return driver.findElement(titlereport).getText();
	}
	// Grab status
	public String getStatus(){
		return driver.findElement(status).getText();
	}
}
