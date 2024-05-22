Feature: Social Media Functionality

  Background:
    Given Navigate to Thüringer Aufbaubank
    Then Verify Thüringer Aufbaubank Page's Title
    And Verify Thüringer Aufbaubank Page's Company Logo

  @Regression
  Scenario: Social Media Functionality
    Then User clicks social media links and verifies
      | Facebook  |
      | Xing      |
      | Linkedin  |
      | Youtube   |



