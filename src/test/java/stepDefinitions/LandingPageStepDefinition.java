package stepDefinitions;



import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;



public class LandingPageStepDefinition {

	TestContextSetup testContextSetup;
	LandingPage landingPage;
	
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreeKart landing page")
	public void user_is_on_gree_kart_landing_page() {

		landingPage.goToUrl();
		Assert.assertTrue(landingPage.getTitleLendingPage().contains("GreenKart"));
	}
	@When("^User searched with shortname (.+) and the product is found$")
	public void user_searched_with_shortname_and_the_product_is_found(String shortName) throws InterruptedException {
		
		landingPage.searchItem(shortName);
	    Thread.sleep(1000);
	    testContextSetup.landingPageProductName = landingPage.getProductName();
	    System.out.println(testContextSetup.landingPageProductName + " is extracted from Home page");  
	    
	}
	
	@When("^increase item quantity to (.+) and add item to cart$")
	public void increase_item_quantity_and_add_to_cart(Integer quantity) throws InterruptedException {
	    
		Thread.sleep(2000);
		landingPage.increaseQuantity(quantity);
		System.out.println(testContextSetup.landingPageProductName + " added to cart time: " + quantity.toString());
		landingPage.addItemToCart();
		landingPage.goToCart();
		
	}
}
