@regression
Feature: Testing starting using app feature

  Scenario: User starts theScoreApp an chooses favorites

    Given User clicks get started button on starter page
    And   User swipes 'up' to choose 'NHL Hockey' and clicks continue
    When  User swipes 'left' to choose 'NHL' from recommended
    And   User swipes 'up' to choose 'Boston Bruins' and clicks continue
    When   User clicks continue button on starter page Maybe later on SignUp Page
    Then   User validates that he is on the 'Favorites' Page

