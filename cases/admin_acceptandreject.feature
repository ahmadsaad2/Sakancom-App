Feature: Admin can accept or reject a housing advertisement
  Scenario: a Admin accepts the advertisement
    Given that the user is an admin
    When  the admin recieves a housing advertisement with id <1> and admin chooses to <"Accept"> it
    Then the house is accepted


  Scenario: a Admin rejects the advertisement
    Given that the user is an admin
    When  the admin recieves a housing advertisement with id <2> the admin chooses to <"Reject"> it
    Then the house is rejected