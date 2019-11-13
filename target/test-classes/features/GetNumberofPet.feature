#Feature: API needs to return number of pets for each status
#    ##https://petstore.swagger.io/#/pet/findPetsByStatus
#
#    Scenario:List all status types and check total number of pets
#         Given I get number of "sold" pets
#         When I create a pet with a status of "sold"
#         Then I should see "sold" pets increased one