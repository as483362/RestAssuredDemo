Feature: List of user service API test
  As a User
  I want to check list of user service API details,
  so that I can verify the user details

  Background: 
    Given I have a user resource API detail

  @users
  Scenario: Verify list of user service API status
    When I make a GET request to "users"
    Then I get a 200 status code in response

  @users
  Scenario Outline: Verify UserName and Email detail for <userId> in List of users API
    When I send a GET request to "users" with <userId> value
    Then I should see username <userName> and <email> details in response

    Examples: 
      | userId | userName  | email             |
      |      1 | Bret      | Sincere@april.biz |
      |      2 | Antonette | Shanna@melissa.tv |
