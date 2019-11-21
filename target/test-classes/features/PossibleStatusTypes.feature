Feature: Create pet with all possible status types

  Scenario Outline: Generating new pet with Status
    When I generate a new peth with "<status>" status
    Then I check newly created pet's status is "<status>"
    Examples:
      | status    |
      | available |
      | pending   |
      | sold      |