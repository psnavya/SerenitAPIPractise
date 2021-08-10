package com.aviation.apiautomation.stepdefinitions;

import com.aviation.apiautomation.helpers.ApiEndPointHelper;
import com.aviation.apiautomation.helpers.response.DataHelper;
import com.aviation.apiautomation.helpers.response.PaginationHelper;
import com.aviation.apiautomation.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.IOException;


public class RealTimeFlightSteps {

    static String endPoint;
    static Response response;
    @Given("i search real time flight")
    public static void searchRealTimeFlight() throws IOException {
        endPoint = ConfigurationReader.getPropertyValue(ApiEndPointHelper.
                ENDPOINT_REALTIME_FLIGHTS.getEndpoint());
        response= RestAssured.given().log().all().when().get(endPoint);

    }
    @Then("my real time flight search is successful")
    public void searchSuccessful() {
        response.then().assertThat().statusCode(200);
    }

    @Then("i find real time flight {string} details of {string} with {string}")
    public void iFindRealTimeFlightDetails(String type, String subtype, String value)  {
        DataHelper.containsValue(type,response,subtype,value);
    }
    @Then("i expect real time flight pagination {string} details to be {int}")
    public void iExpectRealTimeFlightPaginationDetails(String type, int value)  {
        PaginationHelper.containsValue(response,type,value);
    }
}
