Feature: Calculate different percentage values


  Scenario: User calculates different percentages
    Given User is on percentage calculator page
    Then User should see following calculations results
    |100|5|
    |500|25|
    |1000|50|
    |1300|65|
    |2100|105|
