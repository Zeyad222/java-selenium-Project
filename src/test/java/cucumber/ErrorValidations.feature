@tag
Feature: Error validation
  @tag2
  Scenario Outline: Positive Test for submitting the order
  Given I landed on Ecommerce page
  When Logged in with useremail <useremail> and password <password>
  Then "Incorrect email or password." message is displayed with warning

  Examples:
  | useremail                   |   password   |
  | zeyad_alaa222@outlook.com   | #1541asdas#   |