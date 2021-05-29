package pages.actions;

import java.awt.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import pages.locators.CreateAccountPageLoactors;
import utils.SeleniumDriver;

public class CreatAccountPageActions {

	CreateAccountPageLoactors createAccountPageLoactors = new CreateAccountPageLoactors();
	
	public CreatAccountPageActions() {
		this.createAccountPageLoactors = new CreateAccountPageLoactors();
		PageFactory.initElements(SeleniumDriver.getDriver(), createAccountPageLoactors);
	}
	
	public void enterDetails(DataTable dataTable) {
//|title|firstName|lastName|password|dob|address|city|state|zipCode|mobile|alias|
			String title = dataTable.cell(1, 0);
			if ( title == "Mr"){
				createAccountPageLoactors.title1.click();
			}
			else createAccountPageLoactors.title2.click();
			createAccountPageLoactors.firstName.sendKeys(dataTable.cell(1, 1));
			createAccountPageLoactors.lastName.sendKeys(dataTable.cell(1, 2));
			createAccountPageLoactors.setPassword.sendKeys(dataTable.cell(1, 3));
			String[] dob = dataTable.cell(1, 4).split("-");
			Select birthDay = new Select(createAccountPageLoactors.birthDay);
			birthDay.selectByValue(dob[0]);
			Select birthMonth = new Select(createAccountPageLoactors.birthMonth);
			birthMonth.selectByValue(""+Integer.parseInt(dob[1]));
			Select birthYear = new Select(createAccountPageLoactors.birthYear);
			birthYear.selectByValue(dob[2]);
			createAccountPageLoactors.addressLine1.sendKeys(dataTable.cell(1, 5));
			createAccountPageLoactors.city.sendKeys(dataTable.cell(1, 6));
			createAccountPageLoactors.state.sendKeys(dataTable.cell(1, 7));
			createAccountPageLoactors.postcode.sendKeys(dataTable.cell(1, 8));
			createAccountPageLoactors.mobile.sendKeys(dataTable.cell(1, 9));
			createAccountPageLoactors.alias.sendKeys(dataTable.cell(1, 10));
	}
	
	public void registerButton() {
		createAccountPageLoactors.registerButton.click();
	}
}
