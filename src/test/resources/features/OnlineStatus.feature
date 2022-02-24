@ETSKY-323
Feature:default

  Background:
    Given the user accesses the Log in page
    And the user login with valid credential "Employee1" "Employee123"
    Then click User Avatar module and click Status Item

#*Akif:*
#US:
#As a user, I should be able to change my online status and set a status message

#AC:
#User can view Online Status
#User can change Online Status
#User can set a status message

  Scenario Outline: User can chance online status and set a status message
    Given The user clicks an "<option>" on the online status section
    Then  The user writes any status message
    And   The user clicks set status message button
    Then  click User Avatar module
    Then  status message must be chanced
    Examples:
      | option    |
      | online    |
      | away      |
      | dnd       |
      | invisible |


  Scenario Outline: User can chance online status and set a status message
    Given The user clicks an "online" on the online status section
    Then The user selects a "<prepared Status Option>"
    And   The user clicks set status message button
    Then  click User Avatar module
    Then  status message must be selected prepared status message
    Examples:
      | prepared Status Option |
      | Commuting              |
      | In a meeting           |
      | Working remotely       |
      | Out sick               |
      | Vacationing            |
