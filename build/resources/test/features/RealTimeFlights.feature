Feature: Aviation API checks for endpoint Real Time Flights

  Background:
    Given i verify the authorisation key
    And i validate successful authorisation

  @Test
  Scenario Outline: Tracking and retrieving real time flight pagination count
    Given i search real time flight
    When my real time flight search is successful
    Then i expect real time flight pagination "<type>" details to be <count>
    Examples:
      |type   |count |
      | offset|0    |
      | limit |100    |
      | count |  50  |
      | total |  7600|

  @Test
  Scenario Outline: Tracking and retrieving real time data
    Given i search real time flight
    When my real time flight search is successful
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

