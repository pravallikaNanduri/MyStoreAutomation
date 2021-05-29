package StepDefinitions;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.actions.CreateAccountPageActions;
import pages.actions.HomePageActions;
import pages.actions.LoginPageActions;
import utils.SeleniumDriver;

public class LoginSteps extends SeleniumDriver {

	LoginPageActions loginPageActions = new LoginPageActions();
	CreateAccountPageActions creatAccountPageActions = new CreateAccountPageActions();
	HomePageActions homePageActions = new HomePageActions();

	@Given("user navigates to the website <URL> and clicks sign in")
	public void user_navigates_to_the_website_and_clicks_sign_in(String websiteURL) {
		SeleniumDriver.openPage(websiteURL);
		SeleniumDriver.takeScreenshot();
		homePageActions.clickSignIn();
		SeleniumDriver.takeScreenshot();
	}

	@When("the New user logs in using valid Email address as <email>")
	public void the_new_user_logs_in_using_valid_email_address_as_email(DataTable dataTable) {
		for(int i=1; i<dataTable.height();i++) {
			loginPageActions.createAccount(dataTable.cell(i, 0));
			SeleniumDriver.takeScreenshot();
		}
	}

	@When("the user clicks Create an account button")
	public void the_user_clicks_create_an_account_button() {
		loginPageActions.clickCreateAccount();
		SeleniumDriver.takeScreenshot();
	}

	@When("user should be redirected to create account page and enters details")
	public void user_should_be_redirected_to_create_account_page_and_enters_the_details(DataTable dataTable) {
		creatAccountPageActions.enterDetails(dataTable);
		SeleniumDriver.takeScreenshot();
	}

	@When("clicks Register")
	public void clicks_Register() {
		creatAccountPageActions.registerButton();
		SeleniumDriver.takeScreenshot();
	}

	@Then("user should be redirected to home page")
	public void user_should_be_redirected_to_home_page() {
		SeleniumDriver.takeScreenshot();
		Assert.assertEquals("My account - My Store", SeleniumDriver.getDriver().getTitle());
	}

	@When("the New user logs in using invalid Email address as <email>")
	public void the_new_user_logs_in_using_invalid_email_address_as_email(DataTable dataTable) {
		for(int i=1; i<dataTable.height();i++) {
			loginPageActions.createAccount(dataTable.cell(i, 0));
			SeleniumDriver.takeScreenshot();
		}
	}

	@Then("error must be displayed")
	public void error_must_be_displayed() {
		loginPageActions.verifyErrorCreateAccount();
		SeleniumDriver.takeScreenshot();
	}

	@When("there Existing user logs in using Email address as <email> and Password as <password>")
	public void there_existing_user_logs_in_using_email_address_as_email_and_password_as_password(DataTable dataTable) {
		for (int i = 1; i < dataTable.height(); i++) {
			loginPageActions.alreadyRegisteredSignIn(dataTable.cell(i, 0),dataTable.cell(i, 1));
			SeleniumDriver.takeScreenshot();
		}
	}

	@When("the user clicks Sign in button")
	public void the_user_clicks_sign_in_button() {
		loginPageActions.clickSignIn();
		SeleniumDriver.takeScreenshot();
	}

	@Then("login must be successful.")
	public void login_must_be_successful() {
		SeleniumDriver.takeScreenshot();
		Assert.assertEquals("My account - My Store", SeleniumDriver.getDriver().getTitle());
	}

	@When("the Existing user logs in using invalid Email address as <email> and invalid Password as <password>")
	public void the_existing_user_logs_in_using_invalid_email_address_as_email_and_invalid_password_as_password(DataTable dataTable) {
		((JavascriptExecutor) SeleniumDriver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
		for (int i = 0; i < dataTable.height(); i++) {
			loginPageActions.alreadyRegisteredSignIn(dataTable.cell(i, 0),dataTable.cell(i, 1));
			SeleniumDriver.takeScreenshot();
			loginPageActions.clickSignIn();
		}
	}

	@Then("login must be unsuccessful an appropriate error should be dispayed.")
	public void login_must_be_unsuccessful_an_appropriate_error_should_be_dispayed() {
		((JavascriptExecutor) SeleniumDriver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
		loginPageActions.verifyErrorloginAccount();
		SeleniumDriver.takeScreenshot();
	}

}
