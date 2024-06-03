@test
Feature: Testing leagues features

  Scenario Outline: Testing Leagues sub tabs functionality
    Given User clicks get started button on starter page
    And   User swipes 'up' to choose "<league>" and clicks continue
    When  User swipes 'left' to choose "<recommended>" from recommended
    And   User swipes 'up' to choose "<team>" and clicks continue
    When   User clicks continue button on starter page Maybe later on SignUp Page
    Then   User validates that he is on the 'Favorites' Page
    When  User clicks on Leagues tab
    Then  User validates that he is on the 'Leagues' Page
    When  User use scroll 'up' and chooses "<leagues>" from leagues
    Then  User validates that he is "<leagues>" page
    And   User validates "<subTabs>" as sub tabs
  Examples:
    |league                |recommended |team             |leagues       |subTabs                         |
    |UEFA Champions League |England     |Manchester United|Germany Soccer|FIXTURES NEWS CHAT TABLE LEADERS|

