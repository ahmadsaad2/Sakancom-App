Feature: Residence

Scenario: Add a new residence
When i enter the id <3> of reisdences to add it
Then  i will save itt <"the operation succesfull">

Scenario: Exist residence
When i enter the id <1> of reisdences to add itt
Then i thee output <"this is already exist">

 