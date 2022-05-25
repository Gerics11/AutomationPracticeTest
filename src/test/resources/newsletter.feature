Feature: Subscription to news via email

  Background:
    Given the home page is opened

  Scenario:
    Given newsletter email input is filled with correct email
    When submit button is clicked
    Then success alert message is shown

  Scenario Outline:
    Given the '<field>' is filled with '<email_input>'
    When submit button is clicked
    Then '<err_msg>' error message is shown
    Examples:
      | field            | email_input        | err_msg                                                |
      | newsletter-input | invalidmail        | Newsletter : Invalid email address.                    |
      | newsletter-input | gerics11@gmail.com | Newsletter : This email address is already registered. |