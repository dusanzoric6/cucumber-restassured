Feature: Check API

  Scenario:Querying Elastic Search via API, check for Customer ID List

    Given url of an API is http://localhost:8080/identities
    When APIquery JSON is located on src\test\resources\JSON\query\APIQueryJSON.json
    And POST request is sent
    Then response status code is 200
    And check Customer ID List


  Scenario:Querying Elastic Search via API, check Customer ID List is empty

    Given url of an API is http://localhost:8080/identities
    When APIquery JSON is located on C:\Users\dxz17\IdeaProjects\restassuredWIthCucumber\restassured-with-cucumber\src\test\resources\JSON\query\InvalidAPIQueryJSON.json
    And POST request is sent
    Then response status code is 200
    And check Customer ID List Is Empty

