Feature: Add to Cart

  @Regression @DDT @Positive @AddToCart
  Scenario Outline: User adds a product to the shopping cart
    Given the user is logged in as standard user for adding to cart
    And the user is on the product page for adding to cart
    And the user see the "<product_name>" item
    When the user clicks the "<product_name>" Add to Cart button
    Then the cart should display 1 item
    And the "<product_name>" Add to Cart button should not present
    And the "<product_name>" Remove from Cart button should present

    Examples:
      | product_name                      |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |