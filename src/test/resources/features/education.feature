Feature: add education

  Scenario: create a new user and and add education
    Given Send a request for registering new user with POST method
    When Verify that new user is created
    When Get user by ID with GET method
    And Login and Get Token with POST method
    And Get user's all educations with GET method
    And Verify that there is NO any education information
    And Add education to user with POST method
    Then Verify that education is added
    Then Delete this new user
    Then Verify that new user is deleted


  Scenario Outline: Education information Verification
    Given Get a user by <User ID>
    When Verify that the status code is <status code>
    Then Verify that first education information <education id> , "<school>" , "<degree>"

    Examples:
      | User ID | status code | education id | school | degree      |
      | 1038    | 200         | 795          | UÜ    | engineering |

  @wip
  Scenario Outline: Education information Verification with gson
    Given Get a user by <User ID>
    And Login with "thomasAnderson@gmail.com" and "123456" and Get Token
    When Get user's all educations with GET method
    Then Verify that first education information <education id> , "<school>" , "<degree>" with gson

    Examples:
      | User ID  | education id | school | degree      |
      | 1038     | 795          | UÜ    | engineering |