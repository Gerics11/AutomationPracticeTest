Feature: cart functionality on the webshop

  Background:
    Given the home page is opened

  Scenario:
    When cart button is clicked
    Then 'Your shopping cart is empty.' alert message is shown

  Scenario:
    Given item is added to cart
    When proceed to checkout button is clicked
    Then proceed to checkout button is active

  Scenario:
    Given item is added to cart
    And proceed to checkout button is clicked
    When proceed to checkout is clicked on cart summary page
    Then authentication page is opened

  Scenario:
    Given item is added to cart
    And proceed to checkout button is clicked
    And quantity is set to one
    When quantity of product is incremented
    Then shopping cart total increased by one

  Scenario:
    Given item is added to cart
    And proceed to checkout button is clicked
    And proceed to checkout is clicked on cart summary page
    And correct email address is entered
    And correct password is entered
    And submit sign in with credetials button is clicked
    Then address page is shown

