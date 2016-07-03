package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MassPromoCallValidate {
	WebDriver driver;
	By header = By.id("vodh2");
	By detail1 = By.xpath("//tr[@id='dpi_1']/td[3]");
	By product1 = By.id("1.Call2_Discussion_vod__c.Product_vod__c");
	By detail2 = By.xpath("//tr[@id='dpi_2']/td[3]");
	By product2 = By.id("2.Call2_Discussion_vod__c.Product_vod__c");
	
	public MassPromoCallValidate(WebDriver driver){
		this.driver = driver;
	}
	// Grab Promo report
	public String getPromo(){
		return driver.findElement(header).getText();
	}
	// Get Detail 1
	public String getDetail1(){
		return driver.findElement(detail1).getText();
	}
	// Get Product 1
	public String getProduct1(){
		return new Select(driver.findElement(product1)).getFirstSelectedOption().getText();
	}
	// Get Detail 2
	public String getDetail2(){
		return driver.findElement(detail2).getText();
	}
	// Get Product 2
	public String getProduct2(){
		return new Select(driver.findElement(product2)).getFirstSelectedOption().getText();
	}
}
