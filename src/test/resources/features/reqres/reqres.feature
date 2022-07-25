Feature: Request to API Reqres

  @smoke @regression
  Scenario Outline: Get list user
    Given Get list user with parameter "<parameter>"
    When Send request get list user
    Then Status coded should be 200 OK
    And Response body should contain "<firstName>" and "<lastName>"
    And Get list user assert json validation
    Examples:
    |parameter  | firstName | lastName  |
    |1          | George    | Bluth     |
    |2          | Michael   | Lawson    |

  @regression
  Scenario: Post create user
    Given Post create new user with valid json file
    When Send request post create user
    Then Status code should be 201 Created
    And Response body should contain name "DhandyJoe" and "QA Engineer"
    And Post create user assert json validation

  @regression
  Scenario Outline: Put update user
    Given Put update user with id "<id>" valid json file
    When Send request put update user
    Then Status coded should be 200 OK
    And Response body should contain name "DhandyJoe-Updated" and "QA Engineer"
    And Put update user assert json validation
    Examples:
    |id   |
    |1    |

  @regression
  Scenario Outline: Delete user
    Given Delete user with id "<id>"
    When Send request delete user
    Then Status code should be 204
    Examples:
    |id   |
    |1    |


