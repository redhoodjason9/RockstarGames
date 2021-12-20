Feature: Adding and fetching from database

  Scenario: Adding a game to the database
    Given No games in database
    When Adding a game to database
    Then The game should be present in database
