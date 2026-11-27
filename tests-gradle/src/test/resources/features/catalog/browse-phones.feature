Feature: Browse phones
  The phones category lists all phones.

  Scenario: Phones category
    When I browse the "phones" category
    Then I see 3 products
