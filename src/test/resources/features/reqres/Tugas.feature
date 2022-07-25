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
