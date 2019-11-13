Feature: Generate & Update a pet
    Scenario: Generate new pet and update usingID
        Given I create a pet
        When I check newly created pet
        Then I update my pet
        Then I check updated pet

    Scenario: One should be able to change status of pet
        Given I create a pet called Garfield
        When I change status to "sold"
        Then I should get "sold" for the pet

