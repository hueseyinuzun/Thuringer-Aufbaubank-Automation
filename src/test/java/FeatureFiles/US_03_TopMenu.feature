Feature: Top menu Functionality

  Background:
    Given Navigate to Thüringer Aufbaubank
    Then Verify Thüringer Aufbaubank Page's Title
    And Verify Thüringer Aufbaubank Page's Company Logo

  @SmokeTest
  Scenario: Top menu Functionality
    Then User hover over top menu links and verifies


