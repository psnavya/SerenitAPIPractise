Feature: Aviation API checks for Historical flights

  Background:
   Given i verify the authorisation key
   And i validate successful authorisation

  @Test2
  Scenario Outline: Tracking and retrieving historical flight status
    Given i search historical flight by flight date "2019-02-31"
    When my historical flight search is successful
    Then i find real time flight "<type>" details of "<subtype>" with "<value>"
    Examples:
      |type      |subtype        |value|
      |Flight Date|              |2021-08-08|
      |Flight Status|            |Scheduled|
      |Departure |timezone       |Asia/Shanghai|
      |Arrival   |iata           |DFW|
      |Airline   |name           |American Airlines|
      |Flight    |icao           |AAL1004|
      |Aircraft  |registration   |N160AN|
      |Live      |altitude       |8846.820|

  @Test2
  Scenario : Tracking and retrieving historical flight status
    Given i search historical flight by flight date "2019-02-31"
    When my historical flight search is successful
    Then i verify that  real time flight value against parameter "departure" "timezone" is "Asia/Shanghai"
   #convert above to scenario outline