Feature: Testing the Sign in page

  Background:
    Given the home page is opened
    And the Sign In Button is clicked

  Scenario Outline:
    Given the '<field>' is filled with '<email_input>'
    When Create an account Button is clicked
    Then the '<err_msg>' error message is shown
    Examples:
      | field        | email_input        | err_msg                                                                                                              |
      | email_create | invalidmail        | Invalid email address.                                                                                               |
      | email_create |                    | Invalid email address.                                                                                               |
      | email_create | gerics11@gmail.com | An account using this email address has already been registered. Please enter a valid password or request a new one. |

  Scenario:
    Given correct email address is entered
    And correct password is entered
    And submit sign in with credetials button is clicked
    When sign out button is clicked
    Then sign in page is shown

  Scenario:
    Given correct email address is entered
    And correct password is entered
    When submit sign in with credetials button is clicked
    Then account page is shown






