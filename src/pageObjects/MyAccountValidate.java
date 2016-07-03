package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountValidate {
	WebDriver driver;
	By myaccount = By.id("top");
	
	public MyAccountValidate(WebDriver driver){
		this.driver = driver;
	}
	
	public String getMyAccount(){
		return driver.findElement(myaccount).getText();
	}
}
