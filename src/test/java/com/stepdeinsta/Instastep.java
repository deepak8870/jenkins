package com.stepdeinsta;

import org.cucumberbase.BaseClasscucu;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Instastep extends BaseClasscucu {
	
	
	@Given("user is on the insta login page")
	public void user_is_on_the_insta_login_page() {
		
		getdriver();
		geturl("https://www.instagram.com/");
		implicitly(20);
		
	}
	
	@When("user should enter the  {string} and {string}")
	public void user_should_enter_the_and(String string, String string2) {
		

		
		findelementname("username").sendKeys(string);
		findelementname("password").sendKeys(string2);
		
		
		
	}
	
	
	

	

	@Then("user should click the login button")
	public void user_should_click_the_login_button() {
		WebElement element = findelementxpath("//div[text()='Log In']");
		click(element);
		
	}

	@Then("user should verify the success message")
	public void user_should_verify_the_success_message() {

	
	
	}

	
	
	

}
