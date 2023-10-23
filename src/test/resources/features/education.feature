Feature: add education
  @wip
  Scenario: create a new user and and add education
    Given Send a request for registering new user with POST method
    When Verify that new user is created
    When Get user by ID with GET method
    When Verify that the user is new user
    And Login and Get Token with POST method
    And Get user's all educations with GET method
    And Verify that there is NO any education information
    And Add education to user with POST method
    Then Verify that education is added
