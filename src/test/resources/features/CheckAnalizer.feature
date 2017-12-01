Feature: Check analyzer
  Background:
  Scenario Outline:Check ngram_tokenizer_analyzer for last name with tokens

    Given url of an API is http://localhost:8082/identities
    When query JSON is located on src\test\resources\JSON\query\IdentityQueryJSON.json
    And query JSON is modified by changing the last name with the <token>
    And POST request is sent with String
    Then response status code is 200
    And response is checked against query JSON

    Examples: tokens
      | token            |
      | Mil              |
      | ill              |
      | lle              |
      | ler              |
