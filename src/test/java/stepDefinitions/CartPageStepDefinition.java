package stepDefinitions;



import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;



public class CartPageStepDefinition {

	TestContextSetup testContextSetup;
	CartPage cartPage;
	
	
	public CartPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.cartPage = testContextSetup.pageObjectManager.getCartPage();
	}
	
	@Then("^user proceeds to Checkout and validates (.+) (.+) in cart$")
	public void user_on_cart_page_validate_item_qunatity(String productName, String quantity) throws InterruptedException {
	    
	    cartPage.checkOnPage();
	    
//	    Assert.assertEquals(cartPage.getProductName(), productName);
	    Assert.assertEquals(cartPage.getProductQuantity(), quantity);
	}
	

	@Then("user has ability to enter promo code and place order")
	public void enter_promo_code_and_place_order() 
	{
	    Assert.assertTrue(cartPage.verifyPromoCode());
	    Assert.assertTrue(cartPage.verifyPlaceOrder());
	    
	}

}
