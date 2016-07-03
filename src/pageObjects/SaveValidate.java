package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaveValidate {
	WebDriver driver;
	By saving = By.id("saveStatusFooter");
	
	public SaveValidate(WebDriver driver){
		this.driver = driver;
	}
	// Grab saving status
	public String getStatus(){
		return driver.findElement(saving).getText();
	}
}
