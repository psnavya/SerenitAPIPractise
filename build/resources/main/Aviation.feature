Feature: Aviation API Step library

  Scenario: AuthorisationSteps
    * i verify the authorisation key
    * i validate successful authorisation
    #compositeSteps
    * i am verified as an authenticated user

  Scenario: HistoricalFlightSteps
    * i search historical flight by flight date "{string}"
    * my historical flight search is successful
    * i verify that  real time flight value against parameter "{string}" "{string}" is "{string}"
    #compositeSteps
    * i track the historical time flight status on "{string}" of type "{string}" subtype "{string}" with value "{string}"

  Scenario: RealTimeFlightSteps
    * i search real time flight
    * my real time flight search is successful
    * i find real time flight "{string}" details of "{string}" with "{string}"
    * i expect real time flight pagination "{string}" details to be 1
    #compositeSteps
    * i track the real time flight status "{string}" "{string}" "{string}"
    * i verify real time flight pagination "{string}" details to be 1
