Feature: Comment On Posts API test
  As a User
  I want to check comments on posts service API details,
  so that I can verify the comments on post details

  Background: 
    Given I have a user resource API detail

  @comments
  Scenario: Verify comments on posts service API status
    When I make a GET request to "comments"
    Then I get a 200 status code in response

  @comments
  Scenario Outline: Verify CommentId <commentId> details in CommentOnPosts API
    When I send a GET request to "comments" with <commentId> value
    Then I should see comments on post for <commentId> and <postId> details in response

    Examples: 
      | commentId | postId |
      |         1 |      1 |
      |         3 |      1 |

  @comments
  Scenario Outline: Verify user is able to post the comments <commentId> details in CommentOnPosts API
    When I send a POST "comments" request <commentId> <postId> <name> <email> <body> details for CommentOnPosts API
    Then I get a 201 status code in response

    Examples: 
      | commentId | postId | name      | email          | body       |
      |         1 |    101 | Test User | test@gmail.com | Nice Posts |
