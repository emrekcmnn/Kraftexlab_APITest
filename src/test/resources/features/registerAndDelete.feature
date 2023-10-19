Feature: Create a new user and delete this user
  @wip
  Scenario: Register and Delete new user
    Given Send a request for registering new user with POST method
    When Verify that new user is created
    When Delete this new user
    Then Verify that new user is deleted