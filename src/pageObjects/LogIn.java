package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn {
	WebDriver driver;
	By username = By.id("username");
	By password = By.id("password");
	By login = By.id("Login");
	
	public LogIn(WebDriver driver){
		this.driver = driver;
	}
	//Set username in username textbox
	public void setUserName(String strUsername){
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(strUsername);
	}
	//Set password in password textbox
	public void setPassword(String strPassword){
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(strPassword);
	}
	// Click login button
	public void clickLogin(){
		driver.findElement(login).click();
	}
	// Log in with credentials
	public void login(String strUsername, String strPassword){
		// Fill username
		this.setUserName(strUsername);
		// Fill password
		this.setPassword(strPassword);
		// Click login button
		this.clickLogin();
	}
}