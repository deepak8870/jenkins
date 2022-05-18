package org.cucumberpackage;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "E:\\free\\Selenium\\CucumberBase\\src\\test\\resources"
		+ "\\FeatureFILE\\insta.feature",glue="com.stepdeinsta",monochrome=true,
		plugin= {"pretty","json:E:\\free\\Selenium\\CucumberBase\\src\\test\\resources\\FeatureFILE\\output1.json"})



public class TestRun {
	
	
	@AfterClass
	public static void genjvmreport() {
		
		String property = System.getProperty("user.dir");
		
		
		
		Reporting.genereport(property+"\\src\\\\test\\\\resources\\\\FeatureFILE\\\\output1.json"
				);
		
	}

}
