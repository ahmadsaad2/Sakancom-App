Feature: Book House

  I want to be able to book a house
  So that I can secure my accommodation



 Scenario: Booking house
  
When i will inter the number <3> of booking 
Then i will remove the house from avalible house

Scenario: Invalid house

When i will inter the number <200> of booking house
Then the output <"Invalid house selection">
