Feature: User gets the weather by city name

  @First
  Scenario: I enter city name and get the weather

    Given I hit the service endpoint
    Then I get the response
    Then I get the status code 200
    And I get following info in the response
      |main.temp    |282.15|
      |main.pressure|1030  |