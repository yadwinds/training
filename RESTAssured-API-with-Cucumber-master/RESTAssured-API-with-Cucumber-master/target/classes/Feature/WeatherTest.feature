Feature: Test weather by city name

  @Second
  Scenario: User enter a city name with appid to check its weather
    Given Existing city with name "NewDelhi"
    When User gets the weather by city name
    Then The status code is 200
    And Response has the following info
      |main.temp    |300.15|
      |main.pressure|1002 |