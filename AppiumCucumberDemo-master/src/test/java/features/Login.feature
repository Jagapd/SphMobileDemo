Feature: Login to the Straits app

  Scenario: Login to Straits app and validate the headlines
    Given I am on the landing page
    When I enter login as "jaga4work@gmail.com" and password as "Anujag0308"
    Then I should be able to login successfully with "jaga4work@gmail.com"
    Then click on the heading and validate the heading


