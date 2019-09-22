Feature: Make Posts API test
  As a User
  I want to check make posts service API details,
  so that I can verify the posts service details.

  Background: 
    Given I have a user resource API detail

  @posts
  Scenario: Verify make posts service API status
    When I make a GET request to "posts"
    Then I get a 200 status code in response

  @posts
  Scenario Outline: Verify PostId <postId> details in make posts API
    When I send a GET request to "posts" with <postId> value
    Then I should see posts details for <postId> and <userId> details in response

    Examples: 
      | postId | userId |
      |      1 |      1 |
      |      3 |      1 |

  @posts
  Scenario Outline: Verify user is able to post the <postId> details in make posts API
    When I send a POST "posts" request <userId> <postId> <title> <body> details for Posts API
    Then I get a 201 status code in response

    Examples: 
      | userId | postId | title              | body              |
      |      1 |    101 | Rest Assured Title | Rest Assured Body |
