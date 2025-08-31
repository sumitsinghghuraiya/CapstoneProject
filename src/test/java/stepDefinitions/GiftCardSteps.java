package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import constants.FrameworkConstants;
import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.GiftCard;


public class GiftCardSteps{
	WebDriver driver = Hooks.getDriver();
    GiftCard giftCard = new GiftCard(driver);
    
	@Given("User is on home page and select city {string}")
	public void user_is_on_home_page_and_select_city(String city) {
		driver.get(FrameworkConstants.URL);
		 giftCard.searchAndSelectCity(city);
	}
	@When("User click on the {string} icon")
	public void user_click_on_the_icon(String string) {
	   giftCard.clickCheckBalanceIcon();
	}
	@When("User enter an invalid voucher code {string}")
	public void user_enter_an_invalid_voucher_code(String voucherCode) {
	    giftCard.enterVoucherCode(voucherCode);
	}
	@When("User click on the {string} button")
	public void user_click_on_the_button(String string) {
	    giftCard.clickCheckBalanceButton();
	}
	@Then("User should see an error message {string}")
	public void user_should_see_an_error_message(String exceptedErrorMessage) {
	    Assert.assertEquals(exceptedErrorMessage, giftCard.getErrorMessage());
	}
	
//	====================GiftCardNavigation======================
	@When("User navigate to the gift card section")
	public void user_navigate_to_the_section() {
	    giftCard.navigateToGiftCardSection();
	}
	@Then("User should see the {string} icon displayed")
	public void user_should_see_the_icon_displayed(String string) {
		Assert.assertTrue(giftCard.isCheckBalanceIconDisplayed());
	}

}