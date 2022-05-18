package com.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefin {
	
	
	WebDriver driver ;
	
	@Given("user is on the facebook login page")
	public void user_is_on_the_facebook_login_page() {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		
	}

	@When("user should enter the username and password")
	public void user_should_enter_the_username_and_password() {
		
		
		driver.findElement(By.id("email")).sendKeys("hii");
		driver.findElement(By.id("pass")).sendKeys("hi@1232");
		
	}

	@Then("user should click the login button")
	public void user_should_click_the_login_button() {
	
		
		
		driver.findElement(By.name("login")).click();
		
		
		
		
	}

	@Then("user should verify the success message")
	public void user_should_verify_the_success_message() {
		
		System.out.println("sucess");
		
		
	}
	
	

}
