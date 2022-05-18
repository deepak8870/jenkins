package org.cucumberpackage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	
	
	public static void genereport(String jfile) {
		
		File file = new File("E:\\free\\Selenium\\CucumberBase\\src\\test\\resources\\cucumberreport");
		
		Configuration config = new Configuration(file, "instalogin");
		
		config.addClassifications("os", "Windows");
		config.addClassifications("Browser", "chrome");
		config.addClassifications("version", "100");
		config.addClassifications("secenario", "instalogin");
		
		
		List<String > jfiles = new ArrayList<String>();
		
		jfiles.add(jfile);
		
		ReportBuilder bulider = new ReportBuilder(jfiles, config);
		bulider.generateReports();
		
		
		
	}
	
	

}
