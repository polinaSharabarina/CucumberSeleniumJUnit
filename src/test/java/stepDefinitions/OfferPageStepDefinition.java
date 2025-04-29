package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class OfferPageStepDefinition {
	String offerPageProductName;
	TestContextSetup testContextSetup;
	OfferPage offerPage;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.offerPage = testContextSetup.pageObjectManager.getOfferPage();
	}
	
	
	@Then("^User searched for same shortname (.+) and the product is found$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {

		
		switchToOffersPage();
		
		offerPage.searchItem(shortName);
	    
	    Thread.sleep(2000);
	    
	    offerPageProductName = offerPage.getProductName();
	    System.out.println(offerPageProductName + " is extracted from Offers page");
		
	}
	
	
	@Then("The product name from landing page matches the product on Offer page")
	public void validate_productname_matches_Offer_page() {

		Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);
	}
	
	public void switchToOffersPage()
	{
//		check if switched to offer page
		if (!offerPage.checkOnPage())
		{
			LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
			landingPage.selectTopDeals();
			
			
			testContextSetup.genericUtils.switchWindowToChild();
			
		}
	}

}
