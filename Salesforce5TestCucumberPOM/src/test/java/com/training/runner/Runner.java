package com.training.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features={"src/test/resources/com/training/features/SalesForceLoginFeature.feature"},	
					glue="com.training.steps",
					monochrome=false,
					dryRun=false,
					plugin= {"pretty","html:target/cucumber-reports/cucumber.html",
					"json:target/cucumber-reports/cucumber.json" }, 
					tags="@EmptyPassword or @ValidLogin or @RememberMe or @ForgotPassword or @InvalidCredentials"
					)

public class Runner extends AbstractTestNGCucumberTests {

}
