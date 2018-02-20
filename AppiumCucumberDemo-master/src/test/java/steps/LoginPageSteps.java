package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import driver.DriverFactory;

import java.net.MalformedURLException;


public class LoginPageSteps extends DriverFactory {

    public LoginPageSteps() throws MalformedURLException {
    }

    @Given("^I am on the landing page$")
    public void I_am_on_the_landing_page() throws Throwable {
        new LoginPage(driver).waitForLoginScreen();
    }

    @When("^I enter login as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void I_enter_login_as_and_password_as(String username, String password) throws Throwable {
        new LoginPage(driver).Login(username,password);
    }

    @Then("^I should be able to login successfully with \"([^\"]*)\"$")
    public void iShouldBeAbleToLoginSuccessfullyWith(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        new LoginPage(driver).verifyLogin("jaga4work@gmail.com");
    }

    @Then("^click on the heading and validate the heading$")
    public void clickOnTheHeadingAndValidateTheHeading() throws Throwable {
        new LoginPage(driver).navigateToLatest();
        new LoginPage(driver).openFirstArticleandAssert();

    }
    @After
    public void tearDown(){
        killAppiumSession();
    }

}
