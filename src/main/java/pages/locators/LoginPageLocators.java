package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageLocators {

	@FindBy(how=How.ID,using="email_create")
	public WebElement createAccountEmail;
	
	@FindBy(how=How.ID,using="SubmitCreate")
	public WebElement createAnAccountButton;
	
	@FindBy(how=How.ID,using="email")
	public WebElement loginEmailAddress;
	
	@FindBy(how=How.ID,using="passwd")
	public WebElement loginPassword;
	
	@FindBy(how=How.ID,using="SubmitLogin")
	public WebElement signInButton;

	@FindBy(how=How.XPATH,using="//div[@id='center_column']/div[1]/ol/li")
	public WebElement errorMessageLogin;
	
	@FindBy(how=How.XPATH,using="//div[@id='create_account_error']/ol/li")
	public WebElement errorMessageCreateAcct;
	
}
