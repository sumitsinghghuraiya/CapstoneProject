package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import constants.FrameworkConstants;
import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.MovieSearch;

public class MovieSteps {

	WebDriver driver = Hooks.getDriver();
    MovieSearch movieSearch = new MovieSearch(driver);
    @Given("user opens homepage and selects city {string}")
	public void user_opens_homepage_and_selects_city(String city) {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(FrameworkConstants.URL);
		 movieSearch.searchAndSelectCity(city);
	}
   

	//--------------Coming soon -------------------------
    @When("user clicks the first recommended movie")
    public void user_clicks_the_first_recommended_movie()  {
	    // Write code here that turns the phrase above into concrete actions
		 movieSearch.openFirstSuggestedMovie();
	}
	@Then("movie details page opens")
	public void movie_details_page_opens() {
	    // Write code here that turns the phrase above into concrete actions
		 Assert.assertTrue(movieSearch.isTitleVisible(), "Movie details page is not displayed");
	}
	@Then("movie title and poster are visible")
	public void movie_title_and_poster_are_visible() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(movieSearch.isTitleVisible(), "Movie name is not visible");
		 Assert.assertTrue(movieSearch.isPosterVisible(), "Movie poster is not visible");
	}
	@Then("booking option is available")
	public void booking_option_is_available() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(movieSearch.isBookingButtonVisible(), "Booking option is not available");
	}
	@When("user goes to Movies tab")
	public void user_goes_to_movies_tab() {
		    // Write code here that turns the phrase above into concrete actions
	    	 movieSearch.goToMoviesTab();
		}
	@When("chooses {string}")
	public void chooses(String string) {
		    // Write code here that turns the phrase above into concrete actions
			 movieSearch.goToUpcomingMovies();
		}
	@Then("{string} link is shown")
	public void link_is_shown(String string) {
			 Assert.assertTrue(movieSearch.isNowShowingVisible(), "Now Showing link is not visible");
		}
	
	}
