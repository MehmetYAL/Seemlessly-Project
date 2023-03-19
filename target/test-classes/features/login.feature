Feature:
  User Story :

  As a user, I should be able to login.

  "Acceptance Criteria:

  1-User can login with valid credentials (either clicking on the ""Login button"" or hitting the ""Enter"" key from the keyboard as the last step)
  2-User can not login with any invalid credentials
  -""Wrong username or password."" should be displayed for invalid credentials
  -""Please fill out this field"" message should be displayed if the password or username is empty
  3-User can see the password in a form of dots by default
  4-User can see the password explicitly if needed
  5-User can see the ""Forgot password?"" link on the login page and can see the ""Reset Password"" button on the next page after clicking on forget password link
  6-User can see valid placeholders on Username and Password fields"

  Background: login to the page
    Given user is on the login page

  @SEAMLES10-459
# 1-User can login with valid credentials (either clicking on the ""Login button"" as the last step)
  Scenario: User can login with valid credentials by clicking login button
    When user can write valid username
    And user can write valid password
    And user can click login button
    Then user can see dashboard


  @SEAMLES10-461
    # 1-User can login with valid credentials hitting the ""Enter"" key from the keyboard as the last step
  Scenario: User can login with valid credentials by clicking enter
    When user can write valid username
    And user can write valid password
    And user can press enter
    Then user can see dashboard

      #2-User can not login with any invalid credentials
      #  -""Wrong username or password."" should be displayed for invalid credentials
      #  -""Please fill out this field"" message should be displayed if the password or username is empty

  @SEAMLES10-467
  Scenario Outline: User can not login with any invalid credentials
    When user write invalid username "<username>"
    And user write invalid password "<password>"
    And user can click login button
    Then user should see "Wrong username or password."
    Examples:
      | username   | password    |
      | aaabb      | abb123      |
      | aaabb      | employe123  |
      | Employee60 | abb123      |
      | EMPLOYEE60 | Employee123 |

  #2-User can not login with any empty credentials
     #  -""Please fill out this field"" message should be displayed if the password or username is empty

  @SEAMLES10-474
  Scenario Outline: User can not login with any empty credentials

    When user write invalid username "<username>"
    And user write invalid password "<password>"
    And user can click login button
    Then user should see warning message if username or password is empty warning message

    Examples:
      | username | password |
      | abcd     |          |
      |          | abc123   |
      |          |          |

    #AC3- User can see the password in a form of dots by default
@SEAMLES10-478
  Scenario: User can see the password in a form of dots by default
  When user can write valid password
  Then user see the password in a form of dots by default

  #4-AC4- User can see the password explicitly if needed
@SEAMLES10-482
  Scenario: User can see the password explicitly if needed
    When user can write valid password
    And user click the toggle button
    Then user see the password explictly

  #5-AC5-1-User can see the ""Forgot password?"" link on the login page and can see the ""Reset Password"" button on the next page after clicking on forget password link
@SEAMLES10-483
Scenario: User can see the ""Forgot password?"" link and
When user should see the "Forgot password" link

  #5-Ac5-2  user can see the ""Reset Password"" button on the next page after clicking on forget password link
  @SEAMLES10-484
Scenario: user can see the "Reset password" button on the next page after clicking on forget password link
When user click the forgot password button
Then user should see the Reset password button

    #6-US1-Ac6-User can see valid placeholders on Username and Password fields"
  @SEAMLES10-485
  Scenario: User can see valid placeholders on Username and Password fields
    Then user can see valid placeholders on Username fields
    And user can see valid placeholders on Password fields
