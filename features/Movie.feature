@Movies
Feature: Movie Browsing

  Background:
    Given user opens homepage and selects city "Bhopal"

  @NowShowing
  Scenario: View details of first recommended movie
    When user clicks the first recommended movie
    Then movie details page opens
    And movie title and poster are visible
    And booking option is available

  @ComingSoon
  Scenario: Check upcoming movies link
    When user goes to Movies tab
    And chooses "Explore Upcoming Movies"
    Then "In Cinemas Near You" link is shown
