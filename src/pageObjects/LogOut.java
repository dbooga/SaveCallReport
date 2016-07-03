package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOut {
	WebDriver driver;
	By usrnav = By.id("userNavLabel");
	By logout = By.linkText("Logout");
	
	public LogOut(WebDriver driver){
		this.driver = driver;
	}
	// Logout
	public void loggingout(){
		driver.findElement(usrnav).click();
		driver.findElement(logout).click();
	}
}
