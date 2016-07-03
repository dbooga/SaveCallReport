package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectAccount {
	WebDriver driver;
	By account;
	
	public SelectAccount(WebDriver driver){
		this.driver = driver;
	}
	// Set up Account
	public void setAccount(String strAccount){
		account = By.linkText(strAccount);
	}
	// Click on Account
	public void selectAccount(){
		driver.findElement(account).click();
	}
}
