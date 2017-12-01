Feature: Check Identity

  Scenario Outline:<title>

    Given url of an API is http://localhost:8082/identities
    When query JSON is located on <query JSON path>
    And POST request is sent
    Then response status code is 200
    And <what to check>

    Examples:
      | what to check                          | query JSON path                                            | title                                                                             |
      | response is checked against query JSON | src\test\resources\JSON\query\IdentityQueryJSON.json       | By querying EsApp with a JSON query, check all data in query against the response |
      | response body is empty                 | src\test\resources\JSON\query\InvalidIdentityQueryJSON.json| By querying EsApp with an invalid JSON query check that response body is empty    |


