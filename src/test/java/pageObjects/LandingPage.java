package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {
	
	public WebDriver driver;	
	

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By topDeals = By.cssSelector("a.cart-header-navlink");
	private By topDealsLinkText = By.linkText("Top Deals");
	
	private By plusButton = By.cssSelector("a.increment");
//	private By addToCart = By.cssSelector("div[class='product-action'] button[type='button']"); from SelectrosHub
	private By addToCart = By.cssSelector(".product-action button");
	
	
	
	private By cartIcon = By.cssSelector("img[alt='Cart']");
	private By proceedToCheckout = By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");
			
	
	private String landingPageUrl = "https://rahulshettyacademy.com/seleniumPractise/#/";
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText().split("-")[0].trim();
	}

	public void selectTopDeals() {
		List<WebElement> elements = driver.findElements(topDeals);
		elements.get(1).click();
//		testContextSetup.driver.findElement(topDealsLinkText).click();
		
	}

	public void goToUrl() {
		driver.get(landingPageUrl);
	}
	
	public String getTitleLendingPage() {
		return driver.getTitle();
	}
	
	public void increaseQuantity(Integer quantity) {
		WebElement button = driver.findElement(plusButton);
		
		for (int i = 1; i < quantity; i++) 
		{
		     button.click();
		}
	}

	public void addItemToCart() 
	{
		driver.findElement(addToCart).click();
	}

	public void goToCart() {
		driver.findElement(cartIcon).click();
		driver.findElement(proceedToCheckout).click();
		
	}

}
