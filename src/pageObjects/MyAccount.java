package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount {
	WebDriver driver;
	By account = By.linkText("My Accounts");
	
	public MyAccount(WebDriver driver){
		this.driver = driver;
	}
	// Navigate to My Accounts tab
	public void selectMyAccount(){
		driver.findElement(account).click();
	}
}
