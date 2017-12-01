Feature: Check single identity

  Scenario: check identity on local json server

    Given url of an API is http://localhost:3000/identities
    And keyResponse.corelationID number of identity is 123
    When GET request is sent
    Then response status code is 200
    And response is checked