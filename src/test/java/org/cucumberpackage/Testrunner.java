package org.cucumberpackage;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "E:\\free\\Selenium\\CucumberBase\\src\\test\\resources\\FeatureFILE\\fblogin.feature",glue = "com.stepdefb",monochrome=true)



public class Testrunner {
	
	

}
