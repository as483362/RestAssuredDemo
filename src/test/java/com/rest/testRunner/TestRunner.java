package com.rest.testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/", glue = { "com.rest.stepDefinitions" }, plugin = { "pretty",
		"html:target/htmlreports" }, tags = { "@users or @posts or @comments" })

public class TestRunner {

}