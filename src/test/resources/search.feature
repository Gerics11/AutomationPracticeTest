Feature: search function test

  Background:
    Given the home page is opened

  Scenario Outline:
    Given the search bar is filled with '<product_name>'
    And the search button is clicked
    Then '<result_count>' result is found
    Examples:
      | product_name                | result_count |
      | dress                       | 7            |
      | Faded Short Sleeve T-shirts | 1            |
      | John Deere S690 Combine     | 0            |





