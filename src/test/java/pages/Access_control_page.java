package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class Access_control_page {

	BrowserUtils Utils = new BrowserUtils();
	public Access_control_page() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(name = "email")
	public WebElement login_username;
	
@FindBy (name="password")
   public WebElement login_password;

@FindBy (xpath="//button[text()='Login']")
public WebElement login_loginBtn;

@FindBy (linkText = "Forgot Password?")
public WebElement login_forGot_Password_Link;

@FindBy (xpath = "//p[text()='Success!']")
public WebElement login_success_message;

@FindBy (xpath = "//p[text()='Logged in Successfully.']") 
public WebElement login_successful_messag;

public void login (String user_type) {
	Driver.getDriver().get(DataReader.getProperty("app_url"));
	Assert.assertTrue(login_username.isDisplayed());
	 Assert.assertTrue(login_password.isDisplayed());
	 Assert.assertTrue(login_loginBtn.isDisplayed());
	 Assert.assertTrue(login_forGot_Password_Link.isDisplayed());
	 
	 switch (user_type) {
	 case "level1": 
		 Utils.sendkeysWithActionsClass(login_username,DataReader.getProperty("level1_username"));
		 Utils.sendkeysWithActionsClass(login_password,DataReader.getProperty("level1_password"));
		 Utils.clickWithActionsClass(login_loginBtn);	
		 Utils.waitUntilUrlContains("dashboard");	
		 String currentURlString = Driver.getDriver().getCurrentUrl();
		 Assert.assertEquals("http://crater.primetech-apps.com/admin/dashboard", currentURlString);
	     Assert.assertTrue(currentURlString.contains("dashboard"));
	     break;
	 case "level2":
		 Utils.sendkeysWithActionsClass(login_username,DataReader.getProperty("level2_useername"));
		 Utils.sendkeysWithActionsClass(login_password,DataReader.getProperty("level2_password"));
		 Utils.clickWithActionsClass(login_loginBtn);
		 Utils.waitUntilUrlContains("dashboard");	
		 String URl = utils.Driver.getDriver().getCurrentUrl();
		 Assert.assertEquals("http://crater.primetech-apps.com/admin/dashboard", URl);
	     Assert.assertTrue(URl.contains("dashboard"));
	     break;
	 case"level3":
		 Utils.sendkeysWithActionsClass(login_username,DataReader.getProperty("level3_useername"));
		 Utils.sendkeysWithActionsClass(login_password,DataReader.getProperty("level3_password"));
		 Utils.clickWithActionsClass(login_loginBtn);	
		 Utils.waitUntilUrlContains("dashboard");	
		 String URL = utils.Driver.getDriver().getCurrentUrl();
		 Assert.assertEquals("http://crater.primetech-apps.com/admin/dashboard", URL);
	     Assert.assertTrue(URL.contains("dashboard"));
	    break;
	default:
		 Utils.sendkeysWithActionsClass(login_username,DataReader.getProperty("useername"));
		 Utils.sendkeysWithActionsClass(login_password,DataReader.getProperty("password"));
		 Utils.clickWithActionsClass(login_loginBtn);	
		 Utils.waitUntilUrlContains("dashboard");
		 String dashboardUrl = Driver.getDriver().getCurrentUrl();
			Assert.assertEquals("http://crater.primetech-apps.com/admin/dashboard", dashboardUrl);
		    Assert.assertTrue(dashboardUrl.contains("dashboard"));
		
	}
	 

}
}

