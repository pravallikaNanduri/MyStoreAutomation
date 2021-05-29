package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateAccountPageLoactors {
	@FindBy(how=How.ID,using="id_gender1")
	public WebElement title1;
	
	@FindBy(how=How.ID,using="id_gender2")
	public WebElement title2;
	
	@FindBy(how=How.ID,using="customer_firstname")
	public WebElement firstName;
	
	@FindBy(how=How.ID,using="customer_lastname")
	public WebElement lastName;
	
	@FindBy(how=How.ID,using="passwd")
	public WebElement setPassword;
	
	@FindBy(how=How.ID,using="days")
	public WebElement birthDay;
	
	@FindBy(how=How.ID,using="months")
	public WebElement birthMonth;
	
	@FindBy(how=How.ID,using="years")
	public WebElement birthYear;
	
	@FindBy(how=How.ID,using="address1")
	public WebElement addressLine1;
	
	@FindBy(how=How.ID,using="address2")
	public WebElement addressline2;
	
	@FindBy(how=How.ID,using="city")
	public WebElement city;
	
	@FindBy(how=How.ID,using="id_state")
	public WebElement state;
	
	@FindBy(how=How.ID,using="postcode")
	public WebElement postcode;
	
	@FindBy(how=How.ID,using="id_country")
	public WebElement country;
	
	@FindBy(how=How.ID,using="phone_mobile")
	public WebElement mobile;
	
	@FindBy(how=How.ID,using="alias")
	public WebElement alias;

	@FindBy(how=How.ID,using="submitAccount")
	public WebElement registerButton;
}
