package com.cydeo.step_definitions;

import com.cydeo.pages.CalculatorPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.lang.module.Configuration;

public class CalculatorStepDefinitions {

    @Given("User is on calculator page")
    public void user_is_on_calculator_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.calculator.url"));
    }
    @When("User clicks {string} on calculator")
    public void user_clicks_on_calculator(String button) {
        new CalculatorPage().button(button).click();
    }


    @Then("result {string} should be displayed")
    public void resultShouldBeDisplayed(String expectedResult) {
        String actualResult = new CalculatorPage().outPut.getText().trim();
        Assert.assertEquals("Wrong Calculation",expectedResult,actualResult);
    }
}
