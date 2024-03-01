package step_definitions;


import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.Access_control_page;
import pages.Dashboard_page;
import pages.items_page;
import utils.BrowserUtils;
import utils.Driver;

public class ItemsMangement {
	
	Access_control_page Access_control_page =  new Access_control_page();
	Dashboard_page dash_page = new Dashboard_page();
	BrowserUtils utils = new BrowserUtils();
	items_page items_page = new items_page();
	
	String itemname = "";
	String itemprice = "";
	
	@Given("As a {string} user, I am logged in")
	public void as_a_user_i_am_logged_in(String user_type) {
	  Access_control_page.login(user_type);
	}
	@Given("I navigate to items tap")
	public void i_navigate_to_items_tap() throws InterruptedException {
		Thread.sleep(1000);
		dash_page.items_tap.click();
	   utils.waitUntilUrlContains("items");
	   Assert.assertTrue(items_page.items_items_text.isDisplayed());
	}
	@When("I click on add item button")
	public void i_click_on_add_item_button() {
		items_page.items_add_items_button.click();
	}
	@Then("I should be on New Item  page")
	public void i_should_be_on_new_item_page() {
		utils.waitUntilUrlContains("items/create");
		Assert.assertTrue(items_page.items_Input_page_newItem_text.isDisplayed());
	}
	@When("I provife item name {string} price {string} unit {string} and description {string}")
	public void i_provife_item_name_price_unit_and_description(String item_name, String item_price, String item_unit, String item_des) {
		// in oreder to make the item uniqe eachtime, I'm adding random number to the item name before i send keys.
		itemname = item_name + utils.randomNumber();
		itemprice = item_price;
		items_page.items_input_page_name_box.sendKeys(itemname);  
		items_page.items_input_page_price_box.sendKeys(item_price);
		
		// how we choose from the unit drop down. 
		items_page.items_input_page_unit_dropdown.click();
		utils.waitForElementToBeVisible(items_page.items_input_page_unit_pc_option);
		items_page.items_input_page_unit_pc_option.click();
		
	}
	@When("I click Save Item button")
	public void i_click_save_item_button() {
	    items_page.items_page_saveItem_btn.click();
	    utils.waitUntilUrlContains("items");
		   Assert.assertTrue(items_page.items_items_text.isDisplayed());
	}
	@Then("The item is added to the item list table")
	public void the_item_is_added_to_the_item_list_table() throws InterruptedException {
		
		items_page.item_page_success_message.click();
		utils.waitForElementToBeVisible(items_page.items_page_filter_btn);
		
		items_page.items_page_filter_btn.click();
	 
	   utils.waitForElementToBeVisible(items_page.items_page_filter_name_box);
	   items_page.items_page_filter_name_box.sendKeys(itemname);
	   
	   utils.waitUntilElementVisibleWithLocator(By.xpath("//a[text()='"+itemname+"']"));
	   Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[text()='"+itemname+"']")).isDisplayed());
	   
	   Assert.assertTrue(
			   Driver.getDriver().findElement(By.xpath("//span[contains(text(), '"+itemprice.substring(0, 2)+"')]")).isDisplayed());
	   
	   
	}
	
	@Then("I delete the item")
	public void i_delete_the_item() throws InterruptedException {
		
		utils.waitForElementToBeVisible(items_page.items_page_3dot_menu);
		utils.waitUntilElementClickable(items_page.items_page_3dot_menu);
		Thread.sleep(1000);
	    items_page.items_page_3dot_menu.click();
	    utils.waitForElementToBeVisible(items_page.items_page_3dot_delete_option);
	    Assert.assertTrue(items_page.items_page_3dot_delete_option.isDisplayed());
	    items_page.items_page_3dot_delete_option.click();
	    utils.waitForElementToBeVisible(items_page.items_page_delete_ok_btn);
	    items_page.items_page_delete_ok_btn.click();
	   
	    utils.waitForElementToBeVisible(items_page.items_Input_noResultFound_text);
	    Assert.assertTrue(items_page.items_Input_noResultFound_text.isDisplayed());
	}
	    
	    
		// what is hard assert? - hard assert is an assertion like above one, when it fails, it stops the test and marks the test as failed
		   
		  // What is soft assert? - Soft assert is an assertion, when it fails, it doesn't stop the test, but continues the execution of rest of the code.
		  // but also marks the test as failed.
		   
		  // with cucumber, we are using Junit assertions, where there is no concept of soft assert.
		  // Soft assert comes from TestNG - which is a improved sibling of Junit.
	 // update item steps
		@When("I update the item price with {string}")
		public void i_update_the_item_price_with(String newPrice) {
			itemprice = newPrice;
			
			
		   items_page.items_page_3dot_menu.click();
		   utils.waitForElementToBeVisible(items_page.items_page_3dot_edit_option);
		   items_page.items_page_3dot_edit_option.click();
		   utils.waitForElementToBeVisible(items_page.items_page_edit_item_headerText);
		   Assert.assertTrue(items_page.items_page_edit_item_headerText.isDisplayed());
		   
		   // delete the existing price
		   items_page.items_input_page_price_box.clear();
		   
		   items_page.items_input_page_price_box.sendKeys(newPrice);
		   items_page.items_page_update_item_btn.click();
		   utils.waitUntilUrlContains("items");
		   Assert.assertTrue(items_page.items_items_text.isDisplayed());
	}


}
