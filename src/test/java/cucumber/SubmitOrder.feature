@tag
  Feature: Purchase the order from Ecommerce website
    Descriptionss

    Background:
    Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive Test for submitting the order
    Given Logged in with useremail <useremail> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on the ConfirmationPage

    Examples:
    | useremail                   |   password   |   productName   |
    | zeyad_alaa222@outlook.com   | #ReDrunk0#   | IPHONE 13 PRO   |