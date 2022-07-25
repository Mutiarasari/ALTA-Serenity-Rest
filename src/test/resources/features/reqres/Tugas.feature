Feature: Tugas API
@Tugas
Scenario: Get list source
Given Get list user resource
When Send request Get list user resource
Then Status code should be 200 OK
And Get list user resource assert json validation

Scenario: Get single source
Given get single user resource with 2
When Send request get single user resource
Then Status code should be 200 OK
And Get single user resource assert json validation

Scenario: Post Register
Given post register user
When Send request post register
Then Status code should be 200 OK
And Post create register assert json validation

Scenario: Patch user
Given Patch user with 2
When Send Request Patch user
Then Status coded should be 200 OK
And Patch user assert json validation

  Scenario: Get invalid resource
    Given Get single invalid resource with 100
    When send request invalid resource
    Then Status code should be 404 Not found

    Scenario: Get Register ( Fail request responses should be 404 Not found but actual result is 200 )
      Given Get Register
      When send request to register
      Then Status code should be 404 Not found

      Scenario: Post user at invalid url
        Given Post reg to invalid url
        When send request to invalid url
        Then Status code should be 400 Bad Request




