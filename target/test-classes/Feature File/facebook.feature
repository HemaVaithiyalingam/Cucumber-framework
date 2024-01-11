Feature: Facebooklogin

  Background: 
    Given The user is in the loginpage using "chrome" browser

  @fblogin
  Scenario Outline: Login to the facebook page
    When The user enters valid "<username>" and "<password>" for login
    And The user clicks the login button
    Then User checks the result

    Examples: 
      | username     | password     |
      | balakrishnan | 98894565jhh@ |
      | magizhan     | 24615hgh$    |
      | Hemalatha    | 13153@hgj    |

  @forgotpassword
  Scenario: check forgot password option
    Given user clicks forgot password
    When user clicks valid credendials "9894410892"
    And click search
    Then validate the result
