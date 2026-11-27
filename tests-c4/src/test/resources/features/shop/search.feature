Feature: Catalog search
  Shoppers find products by name or by category.

  Scenario: Search by name is case-insensitive
    When I search for "pixel"
    Then I see 1 product

  Scenario: Browse a category
    When I browse the "laptops" category
    Then I see 2 products
