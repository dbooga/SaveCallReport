package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInValidate {
	WebDriver driver;
	By username = By.cssSelector("span.pageType > h1");
	
	public LogInValidate(WebDriver driver){
		this.driver = driver;
	}
	
	public String getUsername(){
		return driver.findElement(username).getText();
	}
}
