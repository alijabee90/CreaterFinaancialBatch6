package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Access_control_page;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class Access_Control_steps {
	
	Access_control_page acp = new Access_control_page();
	BrowserUtils Utils = new BrowserUtils();
	
	@Given("I am on the log in page")
	public void i_am_on_the_log_in_page() {
	   utils.Driver.getDriver().get(DataReader.getProperty("app_url"));
	}
	@Given("login page components exist")
	public void login_page_components_exist() {
	 Assert.assertTrue(acp.login_username.isDisplayed());
	 Assert.assertTrue(acp.login_password.isDisplayed());
	 Assert.assertTrue(acp.login_loginBtn.isDisplayed());
	 Assert.assertTrue(acp.login_forGot_Password_Link.isDisplayed());
	}
	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
	     Utils.sendkeysWithActionsClass(acp.login_username, DataReader.getProperty("username"));
	     Utils.sendkeysWithActionsClass(acp.login_password, DataReader.getProperty("password"));
//	    acp.login_username.sendKeys(DataReader.getProperty("username"));
//	    acp.login_password.sendKeys(DataReader.getProperty("password"));
	}
	@When("I click login button")
	public void i_click_login_button() {
	  Utils.clickWithActionsClass(acp.login_loginBtn);
	}
	@Then("I should be on the Dashboard page")
	public void i_should_be_on_the_dashboard_page() {
		
		Utils.waitUntilUrlContains("dashboard");
		
	   String currentURlString = utils.Driver.getDriver().getCurrentUrl();
	   Assert.assertEquals("http://crater.primetech-apps.com/admin/dashboard", currentURlString);
	   Assert.assertTrue(currentURlString.contains("dashboard"));
	}
	@Then("the Success message displays")
	public void the_success_message_displays() {
	Utils.waitForElementToBeVisible(acp.login_success_message);
	   Assert.assertTrue(acp.login_success_message.isDisplayed());
	}

	// valid login variable steps
	@Then("I should be on the {string} page")
	public void i_should_be_on_the_page(String menu_item) {
		String classValues = Driver.getDriver().findElement(By.xpath("//a[texr()='"+menu_item+"']")).getAttribute("class");
		Assert.assertTrue(classValues.contains("active"));
	}
	@Then("{string} message displays")
	public void message_displays(String successMAssage) {
		Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//p[text()='"+successMAssage+"']")).isDisplayed());
	}

}
