@CitySelection
Feature: City Selection Functionality

  Background:
    Given the user has navigated to the city selection screen

  @ValidCityLookup
  Scenario Outline: Searching with a valid city name
    When the user enters "<city>" in the city search box
    Then the system should display "<city>" in the results list
    And the selected dropdown value should be "<city>"

    Examples:
      | city   |
      | Bhopal |

  @InvalidCityLookup
  Scenario Outline: Searching with an invalid city name
    When the user enters "<city>" in the city search box
    Then an error notification "<message>" should appear

    Examples:
      | city         | message           |
      | AtlantisCity | No results found. |

  @CityIconSelection
  Scenario Outline: Selecting a city by clicking its shortcut icon
    When the user clicks the city icon for "<city>"


    Examples:
      | city  |
      |Delhi|

  @AllCitiesView
  Scenario Outline: Viewing the complete city list
    When the user selects the "<textlink>" option
    Then additional cities such as "<city1>" and "<city2>" should be listed
    And neither "<city1>" nor "<city2>" should appear under the popular cities section

    Examples:
      | city1   | city2       | textlink         |
      | Akola  | Akot | View All Cities  |
