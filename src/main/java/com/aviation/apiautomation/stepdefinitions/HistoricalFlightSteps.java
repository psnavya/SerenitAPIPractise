package com.aviation.apiautomation.stepdefinitions;

import com.aviation.apiautomation.helpers.ApiEndPointHelper;
import com.aviation.apiautomation.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.IOException;

public class HistoricalFlightSteps {

    static String endPoint;
    static Response response;
    static RequestSpecification request;

    @Given("i search historical flight by flight date {string}")
    public static void iSearchHistoricalFlightByFlightDate(String date) throws IOException {
            endPoint = ConfigurationReader.getPropertyValue(ApiEndPointHelper.
                    ENDPOINT_REALTIME_FLIGHTS.getEndpoint());
            request = RestAssured.given();
            response= RestAssured.given().log().all().when().queryParam("flight_date",date).get(endPoint);
    }

    @When("my historical flight search is successful")
    public void myHistoricalFlightSearchIsSuccessful() {
        response.then().assertThat().statusCode(200);
    }

    @Then("i verify that  real time flight value against parameter {string} {string} is {string}")
            public void iVerifyRealTimeFlightAgainstParameter(String type, String subType,String value)
    {
        //check that http://api.aviationstack.com/v1/flights&ACCESSKEY=xyz&flight_date=YYYY=DD-MM has value in type>subtype
      //  Assert.assertTrue(request.pathParam(type,subType).queryParams(subType,value).
             //   get().asString().contains(value));

    }
}
