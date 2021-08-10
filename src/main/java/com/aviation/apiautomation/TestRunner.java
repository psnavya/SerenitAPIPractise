package com.aviation.apiautomation;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue = "com.aviation.apiautomation.stepdefinitions",
        tags="@Test2"
)

public class TestRunner {

}