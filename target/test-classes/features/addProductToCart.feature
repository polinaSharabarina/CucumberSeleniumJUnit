
Feature: Add product to cart and checkout

  @Checkout
  Scenario Outline: User can add multiple items to cart and checkout
    Given User is on GreeKart landing page
    When User searched with shortname <ShortName> and the product is found
    And increase item quantity to <Quantity> and add item to cart
    Then user proceeds to Checkout and validates <LongName> <Quantity> in cart
    And user has ability to enter promo code and place order
    
    Examples: 
    | ShortName | Quantity | LongName |
    | Tom | 3 | Tomato |
    #| Beet | 5 | Beetroot | 
    
