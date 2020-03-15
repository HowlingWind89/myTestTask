Feature: User Tests

@TEST
Scenario: Create new user for Pet Store
  Given I create a new user
  Then I get an username of recently used user

  @TEST
  Scenario: Delete Pet Store user
    Given I create a new user
    And I delete a new user
    And I get an username of recently used user