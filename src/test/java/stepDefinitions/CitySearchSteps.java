package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import constants.FrameworkConstants;
import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.CitySearch;

public class CitySearchSteps {
	WebDriver driver = Hooks.getDriver();
	CitySearch citySearch = new CitySearch(driver);

	@Given("the user has navigated to the city selection screen")
	public void the_user_has_navigated_to_the_city_selection_screen() {
		driver.get(FrameworkConstants.URL);
	}
	@When("the user enters {string} in the city search box")
	public void the_user_enters_in_the_city_search_box(String townName) {
		citySearch.enterTownName(townName);
	}
	@Then("the system should display {string} in the results list")
	public void the_system_should_display_in_the_results_list(String expectedTown) throws InterruptedException {
		Assert.assertTrue(citySearch.checkTownInSearchResults(expectedTown));
    	Thread.sleep(1000);
    	citySearch.pickFirstTownResult();
	}


	//=====invalid========
	
	@Then("an error notification {string} should appear")
	public void an_error_notification_should_appear(String expectedError) {
		String actualErrorMessage = citySearch.fetchErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedError);
	}
	
	//=======city icon search======
	@When("the user clicks the city icon for {string}")
	public void the_user_clicks_the_city_icon_for(String townIcon) {
		 citySearch.pickTownByIcon(townIcon);
	       
	}
	@Then("the selected dropdown value should be {string}")
	public void the_selected_dropdown_value_should_be(String expectedTown) {
		String actualText = citySearch.fetchTownFromDropdown();
        System.out.println(actualText);
        Assert.assertTrue(actualText.contains(expectedTown));
	}
	
	
	//========All cities views ==============
	@When("the user selects the {string} option")
	public void the_user_selects_the_option(String string) {
		 citySearch.openAllTownsView();
	}
	@Then("additional cities such as {string} and {string} should be listed")
	public void additional_cities_such_as_and_should_be_listed(String town1, String town2) {
		  Assert.assertTrue(citySearch.checkTownInAllTowns(town1));
	        Assert.assertTrue(citySearch.checkTownInAllTowns(town2));
	}
	@Then("neither {string} nor {string} should appear under the popular cities section")
	public void neither_nor_should_appear_under_the_popular_cities_section(String town1, String town2) {
		 Assert.assertFalse(citySearch.checkTownInPopularList(town1));
	        Assert.assertFalse(citySearch.checkTownInPopularList(town2));
	}
}
