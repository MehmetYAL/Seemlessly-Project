
@smoke @SEAMLES10-381
Feature: User Story :
  As a user, I should be able to log out.
  Acceptance Criteria:
  1-User can log out and ends up in login page
  2-User can not go to home page again by clicking step back button after successfully logged out.

  Background: user log in to the page
    Given user is on the login page
    When user can write valid username
    And user can write valid password
    And user can click login button
    Then user can see dashboard




  @SEAMLES10-512
  #1-User can log out and ends up in login page
  Scenario: user log out and go to log in page

    When click log out image
    And click log out
    And user is on the login page
    And user can logout successfully

  @SEAMLES10-511
    #2-User can not go to home page again by clicking step back button after successfully logged out.
Scenario: User can not go to home page again by clicking step back button after logged out.
  When click log out image
  And click log out
  And user is on the login page
  And user click the step back button
  Then user can not go to home page again






