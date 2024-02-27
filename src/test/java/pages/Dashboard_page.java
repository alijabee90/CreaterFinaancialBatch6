package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class Dashboard_page {
   
	public Dashboard_page() {
		PageFactory.initElements(Driver.getDriver(),this);
	}
	@FindBy (xpath ="//span[text()'Ampunt Due']")
	public WebElement Dashboard_amountDueText;
	
	@FindBy (xpath = "//a[text()=' Items']")
	public WebElement items_tap;
	
}
