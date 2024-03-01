@regression
Feature: Access control user management
         Use cases for app access control
         
         @Valid_login @smoke_test
         Scenario: As a user, I should be able to login
         Given I am on the log in page
         And login page components exist
         When I enter valid username and valid password
         And I click login button
         Then I should be on the Dashboard page
         And the Success message displays
         
         @valid_login_variable
         Scenario: As a user, I should be able to login
         Given I am on the log in page
         And login page components exist
         When I enter valid username and valid password
         And I click login button
         Then I should be on the " Dashboard" page
         And  "Success!" message displays
         
         
         @invalid_login
         Scenario Outline: As a user, I should not be able to login with invalid credentials
         Given I am on the Login page
         When I entre invalid username "<username>" and password "<password>"
         And I click login button
         Then I should not be logged in
         
         Examples:
         | username                       | password           |
         | notreal@primetechschool.com    | notrealPassword    |
         | notreal@primetechschool.com    | primetech@school   |
         | dummy@primetechschool.com      |                    |
         |                                | primetech@school   |
         
        
         
         