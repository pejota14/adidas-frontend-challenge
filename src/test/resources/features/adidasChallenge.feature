Feature: shopping feature

  @TEST_001
  Scenario: Adding two products to cart, delete one and purchase
    Given the user switches to Laptops category and selects Sony vaio i5
    When the user adds the product to cart
    And the user navigates to Home
    And the user switches to Laptops category and selects Dell i7 8gb
    When the user adds the product to cart
    And the user navigates to Cart
    And the user removes Dell i7 8gb from cart
    Then the basket has 1 product
    When the user places the order with their personal data
      | name  | country | city       | creditCard       | month | year |
      | James | Spain   | Valladolid | 4700000000000000 | 12    | 30   |
    Then the purchase amount equals cart amount
    And the user accepts
