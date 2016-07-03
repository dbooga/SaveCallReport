package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectAccountValidate {
	WebDriver driver;
	By account = By.cssSelector("h2.pageDescription");
	
	public SelectAccountValidate(WebDriver driver){
		this.driver = driver;
	}
	// Grab Account Name
	public String getAccountName(){
		return driver.findElement(account).getText();
	}
}
