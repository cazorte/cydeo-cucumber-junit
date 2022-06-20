package com.cydeo.step_definitions;

import com.cydeo.pages.CalculatorPage;
import com.cydeo.pages.PercentagePage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import java.lang.module.Configuration;
import java.util.Map;

public class CalculationStepDefs {

    @Given("User is on percentage calculator page")
    public void user_is_on_percentage_calculator_page() {
        System.out.println("User is on the percentage page");
        Driver.getDriver().get(ConfigurationReader.getProperty("web.percentage.url"));
    }
    @Then("User should see following calculations results")
    public void user_should_see_fallowing_calculation_results(Map<Integer,Integer> valuesMap) {
        System.out.println("valuesMap = " + valuesMap);
        PercentagePage page = new PercentagePage();
        page.percent.sendKeys("5");
        // 500 is key --- value is 25=result

        for (Integer inputKey : valuesMap.keySet()) {
            page.input.clear();
            page.input.sendKeys("" + inputKey + Keys.ENTER);

            System.out.println("input value = " + inputKey);
            System.out.println("Expected value of %5 is = " + valuesMap.get(inputKey));

            System.out.println("Actual value from webpage = " + page.result.getAttribute("selectionDirection"));

            Assert.assertEquals(valuesMap.get(inputKey), Integer.valueOf(page.result.getAttribute("value")));




        }
    }

}
