package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfferPage {
	
	public WebDriver driver;
	
	public OfferPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	private By search = By.id("search-field");
	private By firstProduct = By.cssSelector("tr td:nth-child(1)");

			
	
	private String pageUrl = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName() {
		return driver.findElement(firstProduct).getText();
	}

	public boolean checkOnPage() {
		return driver.getCurrentUrl().equalsIgnoreCase(pageUrl);
	}


	
	

	
	

}
