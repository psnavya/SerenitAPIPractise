package com.aviation.apiautomation.tests;

import com.aviation.apiautomation.stepdefinitions.HistoricalFlightSteps;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

import java.io.IOException;

public class HistoricalFlightTests {

    @Steps
    HistoricalFlightSteps historicalFlightSteps;

    @Test
    @Given("i track the historical time flight status on {string} of type {string} subtype {string} with value {string}")
    public void iTrackHistoricalFlightDetails(String date, String type, String subType,String value) throws IOException {
        HistoricalFlightSteps.iSearchHistoricalFlightByFlightDate(date);
        historicalFlightSteps.myHistoricalFlightSearchIsSuccessful();
        historicalFlightSteps.iVerifyRealTimeFlightAgainstParameter(type,subType,value);
         }

}
