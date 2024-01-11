Feature: check the hotel booking module

  Scenario: User login
    Given User is on adacting login page using "chrome" browser
    When User enters the valid credentials using 2D Datatable with heading
      | Username     | password   | type    |
      | alphanumeric | 9894410892 | valid   |
      | bipolar      | disorder   | invalid |
    And User clicks login button
    Then User checks the result and takes screenshot

  Scenario: User is searching a hotel by entering valid credentials
    When Entering valid details using 2D Datatable
      | checkin  | 21/02/2024 |
      | checkout | 23/02/2024 |
    And click search button
    Then User checks the result and takes screenshot1

  Scenario: User booking a hotel
    When User selects the hotel
    Then User checks the result and takes screenshot2

  Scenario: Payment details are given
    When User enters the valid payment details
    And User clicks booknow button
    Then User selects the itinery
    Then User checks the result and takes screenshot3

  Scenario: Use verifying the booking
    When entering the booking id
    And Getting the price
    Then Taking screenshot
