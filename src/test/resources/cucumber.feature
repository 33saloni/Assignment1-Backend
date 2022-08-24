
Feature: Posting the data of customer to database
 
  Scenario: Posting Data 
    Given Id: <id> Name: <name>
    When I invoke store data method 
    Then I verify the status: <status> Id: <id> in response body

    Examples: 
      | id  | name| status  | id
      | 1 | "Saloni" | 200 | 1
      
 
    
