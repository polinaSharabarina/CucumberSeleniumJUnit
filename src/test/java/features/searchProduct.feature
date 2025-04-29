
Feature: Search and Place Order for Products

  @Search
  Scenario Outline: Search experience for product is same on Home and Offers page
    Given User is on GreeKart landing page
    
    When User searched with shortname <Name> and the product is found
    Then User searched for same shortname <Name> and the product is found
    And The product name from landing page matches the product on Offer page
    
    
    Examples: 
    | Name | 
    | Tom |
    | Straw |
    |Beet |
    
