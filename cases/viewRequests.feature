Feature:  House Rental Requests




  Scenario: View Pending Rental Reques

    When i will inter the number <55> to add rented house by owner
    Then i will add it to pending house in admin

  Scenario: invalid add house to pending house

    When  i will inter the number <55> and fail add rented house by owner
    Then the outputt <"No pending">
