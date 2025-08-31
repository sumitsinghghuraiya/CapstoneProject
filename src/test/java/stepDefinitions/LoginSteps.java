package stepDefinitions;

import org.openqa.selenium.WebDriver;

import constants.FrameworkConstants;
import hooks.Hooks;
import io.cucumber.java.en.*;
import org.testng.Assert;


import pages.LoginPage;

public class LoginSteps {
	WebDriver driver = Hooks.getDriver();
    LoginPage loginPage = new LoginPage(driver);
	
	//----- Valid login check ----------------
	
	@Given("User on home page and select the {string}")
	public void user_on_home_page_and_select_the(String city) {
		driver.get(FrameworkConstants.URL);
		 loginPage.searchAndSelectCity(city);
	}
	@Given("User on the login page")
	public void user_on_the_login_page() {
		loginPage.navigateToLogin();
	}
	@When("user enter mobile number {string}")
	public void user_enter_mobile_number(String number) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 loginPage.inputMobileNumber(number); 
	}
	@When("click on continue")
	public void click_on_continue() {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.clickProceed();
	}
	@Then("Verify OTP page")
	public void verify_otp_page() {
	    // Write code here that turns the phrase above into concrete actions
		if (loginPage.isOTPFieldVisible()) {   // ✅ matches
	        Assert.assertTrue(true);
	    } else {
	        Assert.assertTrue(false);
	    }
	}
	@Then("back to login page")
	public void back_to_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		 loginPage.returnToLogin(); 
	}
	//------ invalid login check-----------------
	@When("user enter invalid mobile {string}")
	public void user_enter_invalid_mobile(String mobile) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 loginPage.inputMobileNumber(mobile);
	}
	@Then("verify message {string}")
	public void verify_message(String ErrorMsg) {
	    // Write code here that turns the phrase above into concrete actions
		String actualErrorMsg = loginPage.fetchErrorMessage();   // ✅ matches
	    Assert.assertEquals(actualErrorMsg, ErrorMsg);
	}
   //-------- UI ELEMENT check --------
	@When("verify that mobile number field is visible")
	public void verify_that_mobile_number_field_is_visible() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(loginPage.checkMobileFieldVisible(), "Mobile number field is not visible");
	}
	@Then("verify continue button is not visible")
	public void verify_continue_button_is_not_visible() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertFalse(loginPage.checkProceedButtonVisible());
	}
	@When("user enter valid mobile number {string}")
	public void user_enter_valid_mobile_number(String number) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 loginPage.inputMobileNumber(number); 
	}
	@Then("Verify continue button should enabled")
	public void verify_continue_button_should_enabled() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(loginPage.checkProceedButtonEnabled(), "Continue Button is disabled");
	}
	@When("user enter invalid mobile number {string}")
	public void user_enter_invalid_mobile_number(String number) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.inputMobileNumber(number); 
	}
	@Then("verify continue button is visible but should disable")
	public void verify_continue_button_is_visible_but_should_disable() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(loginPage.checkProceedButtonVisible(), "Continue button is not visible");   
	    Assert.assertTrue(loginPage.checkProceedButtonDisabled(), "Continue button is not disabled");
	}
	@Then("close page")
	public void close_page() {
	    // Write code here that turns the phrase above into concrete actions
		 loginPage.dismissLoginPopup(); 
	}

}
