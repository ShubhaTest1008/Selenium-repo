package com.limeroad_runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.limeroad_base.Base_Class;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "C:\\Users\\shubh\\eclipse-workspace\\limeroad\\src\\test\\java\\com\\limeroad_feature\\limeroad.feature", glue = "com.limeroad_stepdefinition", monochrome = true,

                plugin={ "pretty", "html:Resources/limelogin.html",
	                     "json:Resources/lime_login.json",
	                     "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class RunnerClass extends Base_Class {

	@BeforeClass
	public static void browserLaunch() {

		launchbrowser("chrome");

	}
}
