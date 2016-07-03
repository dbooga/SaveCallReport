package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Save {
	WebDriver driver;
	By save = By.id("btnSave2");
	
	public Save(WebDriver driver){
		this.driver = driver;
	}
	// Select Save
	public void selectSave(){
		driver.findElement(save).click();
	}
}
