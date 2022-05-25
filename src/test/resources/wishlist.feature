Feature: adding items to wishlist

  Background:
    Given the home page is opened

  Scenario:
    Given the Sign In Button is clicked
    And correct email address is entered
    And correct password is entered
    And submit sign in with credetials button is clicked
    And the search bar is filled with 'Faded Short Sleeve T-shirts'
    And the search button is clicked
    When add to wishlist button is clicked
    Then add to wishlist success message is shown
