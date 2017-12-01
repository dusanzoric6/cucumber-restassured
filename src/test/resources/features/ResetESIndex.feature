Feature: Reset ES

  Scenario:Reset Elastic search index and mapping

    Given url of an API is http://localhost:9200/identities
    And DELETE request is sent
    And response status code is 200
    And url of an API is http://localhost:9200/identities
    And mapping JSON sent with request is located on src\test\resources\JSON\resetES\mapping.json
    And PUT request is sent
    And response status code is 200


  Scenario:Input sample data to index

    Given url of an API is http://localhost:9200/identities/identity
    And input_data JSON sent with request is located on src\test\resources\JSON\resetES\input_sample.json
    When POST request is sent
    Then response status code is 201

