Feature: Gift Cards Section

  @smoke @regression
  Scenario: Capture email error message in giftcards
    Given the user able to see homepage
    When the user click on cab option
    And the user click on search
    And the user clicks on more dropdown
    And the user clicks on giftcards option
    And the user selects wedding gift card
    And the user gives senders data "junmungmail.com"
    And the user clicks buy now
    And the user checks for warning message

  @smoke @regression
  Scenario: Checking by giving valid email address
    Given the user able to see homepage
    When the user click on cab option
    And the user click on search
    And the user clicks on more dropdown
    And the user clicks on giftcards option
    And the user selects wedding gift card
    And the user gives valid senders email "junmun@gmail.com"
    And the user clicks buy now button
