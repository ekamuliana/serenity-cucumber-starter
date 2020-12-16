@Quote
Feature: Quote Feature

  @Scenario1
  Scenario: user add quote (1)
    Given User open atlas web playgroud
    When User input quote "There is a will there is a way"
    And User select color "Magenta"
    And User click button add quote
    Then User see quote "There is a will there is a way" with backgorund color "magenta"

  @Scenario2
  Scenario: user add quote (2)
    Given User open atlas web playgroud
    When User input quote "There is a will there is a way"
    And User select color "Yellow"
    And User click button add quote
    Then User see quote "There is a will there is a way" with backgorund color "yellow"

  @Scenario3
  Scenario: user add quote and check table appear by hovering button "hover to show table"
    Given User open atlas web playgroud
    When User input quote "There is a will there is a way"
    And User select color "Magenta"
    And User click button add quote
    And User click table view
    And User hover on button Hover to Show Table
    Then User see table quotes is appear

  @Scenario4
  Scenario: user add quote and check table appear by clicking button "Click to show table after 10 seconds"
    Given User open atlas web playgroud
    When User input quote "There is a will there is a way"
    And User select color "Magenta"
    And User click button add quote
    And User click table view
    And User click button click to show table
    Then User see table quotes is appear

  @Scenario5
  Scenario: user add quote (simulate test data)
    Given User open atlas web playgroud
    When User input quote and remember "There is a will there is a way"
    And User select color and remember "Magenta"
    And User click button add quote
    Then User see quote is equal with the inputted data