package pages.actions;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.locators.LoginPageLocators;
import utils.SeleniumDriver;

public class LoginPageActions {

	LoginPageLocators loginPageLocators = null;
	public static String message="";
	
	public LoginPageActions() {
		this.loginPageLocators = new LoginPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), loginPageLocators);
	}
	
	public void createAccount(String email) {
		((JavascriptExecutor) SeleniumDriver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
		SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(loginPageLocators.createAccountEmail));
		loginPageLocators.createAccountEmail.sendKeys(email);
	}
	
	public void clickCreateAccount() {
		loginPageLocators.createAnAccountButton.click();
	}
	
	public void alreadyRegisteredSignIn(String email,String password) {
		loginPageLocators.loginEmailAddress.clear();
		loginPageLocators.loginPassword.clear();
		((JavascriptExecutor) SeleniumDriver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
		if(!(email==null) && !(password==null)){
			loginPageLocators.loginEmailAddress.sendKeys(email);
			loginPageLocators.loginPassword.sendKeys(password);
			message="";
		}
		else if(email==null && password==null) {
			//no action performed
			message="blankEmailandPassword";
		}
		else if(email==null) {
			loginPageLocators.loginPassword.sendKeys(password);
			message="blankEmail";
		}
		else if(password==null) {
			loginPageLocators.loginEmailAddress.sendKeys(email);
			message="blankPassword";
		}
	}
	
	public String clickSignIn() {
		loginPageLocators.signInButton.click();
		return message;
	}
	public void verifyErrorCreateAccount() {
		((JavascriptExecutor) SeleniumDriver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
		SeleniumDriver.getDriver().manage().timeouts().implicitlyWait(SeleniumDriver.TIMEOUT);
		Assert.assertEquals("Invalid email address.",loginPageLocators.errorMessageCreateAcct.getText());
	}
	
	public void verifyErrorloginAccount() {
		SeleniumDriver.getDriver().manage().timeouts().implicitlyWait(SeleniumDriver.TIMEOUT);
		if (message == "") {
			Assert.assertEquals("Authentication failed.",loginPageLocators.errorMessageLogin.getText());
		}
		else if(message=="blankEmailandPassword") {
			Assert.assertEquals("An email address required.",loginPageLocators.errorMessageLogin.getText());
		}
		else if(message=="blankEmail") {
			Assert.assertEquals("An email address required.",loginPageLocators.errorMessageLogin.getText());
		}
		else if(message=="blankpassword") {
			Assert.assertEquals("Password is required.",loginPageLocators.errorMessageLogin.getText());
		}
		
	}
}
