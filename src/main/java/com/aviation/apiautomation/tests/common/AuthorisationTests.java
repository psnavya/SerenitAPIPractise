package com.aviation.apiautomation.tests.common;
import com.aviation.apiautomation.stepdefinitions.common.AuthorisationSteps;
import io.cucumber.java.en.Given;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

import java.io.IOException;

@RunWith(SerenityRunner.class)
public class AuthorisationTests {
    @Steps
    AuthorisationSteps authorisationSteps;

    @Test
    @Given("i am verified as an authenticated user")
    public  void iAmAnAuthorisedUser() throws IOException {
        AuthorisationSteps.verifyTheAuthorisationKey();
        authorisationSteps.authKeyVerificationSuccessful();
    }


}