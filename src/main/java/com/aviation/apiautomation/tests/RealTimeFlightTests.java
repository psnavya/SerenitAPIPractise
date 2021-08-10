package com.aviation.apiautomation.tests;

import com.aviation.apiautomation.stepdefinitions.RealTimeFlightSteps;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

import java.io.IOException;

public class RealTimeFlightTests {
    @Steps
    RealTimeFlightSteps realTimeFlightSteps;

    @Test
    @Given("i track the real time flight status {string} {string} {string}")
    public void iTrackRealTimeFlightStatus(String type, String subType,String value) throws IOException {
        RealTimeFlightSteps.searchRealTimeFlight();
        realTimeFlightSteps.searchSuccessful();
        realTimeFlightSteps.iFindRealTimeFlightDetails(type, subType,value);
    }
    @Test
    @Given("i verify real time flight pagination {string} details to be {int}")
    public void iVerifyRealTimeFlightPaginationDetails(String type,int value) throws IOException {
        RealTimeFlightSteps.searchRealTimeFlight();
        realTimeFlightSteps.searchSuccessful();
        realTimeFlightSteps.iExpectRealTimeFlightPaginationDetails(type,value);
    }


}
