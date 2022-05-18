package com.stepdefb;

import org.cucumberbase.BaseClasscucu;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepBase extends BaseClasscucu{
	
	
	
	@Given("user is on the facebook login page")
	public void user_is_on_the_facebook_login_page() {
		
		
		getdriver();
		geturl("https://www.facebook.com/");
		
	}

	@When("user should enter the username and password")
	public void user_should_enter_the_username_and_password() {
		
		findelementid("email").sendKeys("deepak");
		findelementid("pass").sendKeys("n12@ma");
		
		
	}

	@Then("user should click the login button")
	public void user_should_click_the_login_button() {
		
		WebElement element = findelementname("login");
		click(element);
		
	}

	@Then("user should verify the success message")
	public void user_should_verify_the_success_message() {
		
		
		sysout("sucess");
		
		
	}


	
	
	
	
	
	

}
