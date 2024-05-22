Feature: Contact us Form

  Background:
    Given Navigate to Thüringer Aufbaubank
    Then Verify Thüringer Aufbaubank Page's Title
    And Verify Thüringer Aufbaubank Page's Company Logo

  @Regression
  Scenario Outline: Datatable Register Scenario

    And Click on the element in the Dialog
      | ContactButton |

    And  User sending the keys in the Dialog content
      | surname | <Name>           |
      | name    | <Vorname>        |
      | email   | <EMail>          |
      | phone   | <TelNummer>      |
      | text    | <Ihre Nachricht> |

    And Click on the element in the Dialog
      | datenverarbeitungCheckbox |
      | datenschutzCheckbox       |

    Examples:
      | Name   | Vorname | EMail                | TelNummer | Ihre Nachricht       |
      | Uzun   | Hüseyin | hueseyin@outlook.com | 017699999 | Thüringer Aufbaubank |
      | Yilmaz | Senay   | senay@outlook.com    | 017600000 | Thüringer Aufbaubank |
      | Müller | Martina | martina@outlook.com  | 016955555 | Thüringer Aufbaubank |