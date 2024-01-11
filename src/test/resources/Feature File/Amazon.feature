Feature: Amazon Page

  Background: 
    Given The user is in the Amazon page

    @smoke
    Scenario: User search for iphone 15 pro and add it to cart
    Given user search for iphone
    When select filter
    Then add it to cart
    
    