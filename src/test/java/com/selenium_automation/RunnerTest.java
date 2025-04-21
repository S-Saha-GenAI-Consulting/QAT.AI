package com.selenium_automation;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty", "json:target/reports/json.json",   //create report in different formats
"html:target/reports/html.html", //pretty used for making the report more readable using indentations
 }, monochrome= false,    //console output is colourful, 
    features = {"src/test/java/com/selenium_automation/Resources/Feature.feature"},   //location of feature file
    glue={"com.selenium_automation.Steps"},                       //location of step definition
    dryRun = false,                      //Don't check if step definition is written for every scenario
    tags = "@Swag_Labs")                      //execute corresponding to different tags in feature

public class RunnerTest extends AbstractTestNGCucumberTests  {

}



