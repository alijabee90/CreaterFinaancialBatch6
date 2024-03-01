@reqreation 
Feature: items Mangments

  @create_items @smoke_test
  Scenario: As a user, I am able to creat an item or service.
    Given As a "level1" user, I am logged in
    And I navigate to items tap
    When I click on add item button
    Then I should be on New Item  page
    When I provife item name "coffee mug" price "1200" unit "pc" and description "very weird coffee mug"
    And I click Save Item button
    Then The item is added to the item list table
    And I delete the item

  @update_items @smoke_test
  Scenario: As a user, I am able to creat an item or service.
    Given As a "level1" user, I am logged in
    And I navigate to items tap
    When I click on add item button
    Then I should be on New Item  page
    When I provife item name "coffee mug" price "1200" unit "pc" and description "very weird coffee mug"
    And I click Save Item button
    Then The item is added to the item list table
    When I update the item price with "1500"
    Then The item is added to the item list table
    And I delete the item
