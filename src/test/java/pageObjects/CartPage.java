package pageObjects;


import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class CartPage {
	
	public WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	private By firstProductName = By.xpath("//p[@class='product-name']");
	
//	.product-name
	//p[@class='product-name']
	private By firstProductQuantity = By.xpath("//p[@class='quantity']");
	private By promoBtn = By.cssSelector(".promoBtn");
	private By placeOrderBtn = By.xpath("//button[normalize-space()='Place Order']");
	
		
	private String pageUrl = "https://rahulshettyacademy.com/seleniumPractise/#/cart";

	public void checkOnPage() throws InterruptedException 
	{
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), pageUrl);
	}

//	public String getProductName() throws InterruptedException {
//		Thread.sleep(2000);
//		return driver.findElement(firstProductName).getText().split("-")[0].trim();
//	}


	public String getProductQuantity() throws InterruptedException {
		
		return driver.findElement(firstProductQuantity).getText();
	}
	
	public Boolean verifyPromoCode() 
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public Boolean verifyPlaceOrder() 
	{
		return driver.findElement(placeOrderBtn).isDisplayed();
	}	
	
	

	
	

}
