package com.aviation.apiautomation.stepdefinitions.common;
import com.aviation.apiautomation.helpers.ApiEndPointHelper;
import com.aviation.apiautomation.helpers.KeyHelper;
import com.aviation.apiautomation.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class AuthorisationSteps {
    static String endPoint;
        static String token;
     static Response response;

    @Given("i verify the authorisation key")
    public static void verifyTheAuthorisationKey() throws IOException {
        endPoint = ConfigurationReader.getPropertyValue(ApiEndPointHelper.
                ENDPOINT_REALTIME_FLIGHTS.getEndpoint());
        token=ConfigurationReader.getPropertyValue(KeyHelper.KEY_HELPER_VALID_KEY.getKey());
        response= given().header("Authorization", "Bearer "+token).when().
                get(endPoint);
    }
    @Then("i validate successful authorisation")
    public void authKeyVerificationSuccessful() {
        response.then().statusCode(200);
    }


}