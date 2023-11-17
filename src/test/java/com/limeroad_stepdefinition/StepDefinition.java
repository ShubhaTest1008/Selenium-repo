package com.limeroad_stepdefinition;

import com.limeroad_base.Base_Class;
import com.limeroad_pom.LoginPom;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Base_Class {

	LoginPom loginpom = new LoginPom(driver);

	@When("User launch the URL {string}")
	public void user_launch_the_url(String string) {
		getUrl("https://www.limeroad.com");
	}

//	@And("User clicks on shop men")
//	public void user_clicks_on_shop_men() {
//		implicitywait(30);
//		clickElement(loginpom.getShopMenBtn());
//	}

	@Then("User Clicks on Shop Women option")
	public void user_clicks_on_shop_women() throws InterruptedException {
		Thread.sleep(3000);
		clickElement(loginpom.getShopWomenBtn());
	}

	@Given("User clicks on {string} option")
	public void user_clicks_on_women_option(String string) throws InterruptedException {
		Thread.sleep(3000);
		//implicitywait(30);
		
		movetoelement(loginpom.getwomenModuleBtn());
	}

	@When("User clicks on Earring option")
	public void user_clicks_on_earring_option() throws InterruptedException {
		Thread.sleep(3000);
		clickElement(loginpom.getearringsBtn());

	}

	@And("User selects the earring")
	public void selectEarring() throws InterruptedException {
		Thread.sleep(3000);
		clickElement(loginpom.getEarrings1());
		

	}

	@Then("User clicks on {string}")
	public void user_clicks_on_AddtoCart(String string) throws InterruptedException {
		Thread.sleep(3000);
		clickElement(loginpom.getAddToCartBtn());

	}

	@And("User close the browser")
	public void user_close_the_browser() throws InterruptedException {
		Thread.sleep(3000);
		closeBrowser();
	}

}
