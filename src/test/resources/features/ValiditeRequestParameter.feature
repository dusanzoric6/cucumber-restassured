Feature: Validate Request Parameter SSN

  Scenario:Sending request to Online API and checking if input parameter (SSN) is valid

    Given url of an API is http://localhost:8080/identities
    When APIquery JSON with valid SSN is located on src\test\resources\JSON\query\APIQueryJSON.json
    And POST request is sent
    Then response status code is 200
    And check that request was valid


  Scenario:Sending request to Online API and checking that input parameter (SSN) is invalid

    Given url of an API is http://localhost:8080/identities
    When APIquery JSON with invalid SSN is located on src\test\resources\JSON\query\InvalidSSNQueryJSON.json
    And POST request is sent
    Then response status code is 200
    And check for the error message


