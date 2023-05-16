Feature: To validate login Functionality
#Given,Then,When,or And
  Scenario: validate valid login functionality
    Given User launches the application
    And user clicks on Sign In Link
    Then the user enters username as "icttest@rediffmail.com" and password as "Test123$$"
    And user clicks on Login Button
    Then user is successfully logged in
    And user closes the application

    Scenario Outline: validate invalid login functionality
      Given User launches the application
      And user clicks on Sign In Link
      Then the user enters username as "<Username>" and password as "<Password>"
      And user clicks on Login Button
      Then Error message is displayed
      And user closes the application
      Examples:
        |Username  |Password|
        |sdwdw     |dgrgbt  |
        |          |efete   |
        |wfwf      |ewefe   |
        |saqib     |        |
        |          |        |
