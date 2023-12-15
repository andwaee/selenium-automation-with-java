Feature: User Profile Functionality

  @UItest
  Scenario: Successful Update of User Profile

    Given user has logged in and is on the homepage
    When user navigates to user profile
    Then user should see that user details are correct
    When user changes the profile details
    Then user should see successful update message