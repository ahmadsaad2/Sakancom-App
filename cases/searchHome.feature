
Feature:  searching home

 
  Scenario: find reissdences
     When i want a home its location  <"street-98"> services <"have balcony">
     Then i given id  home  <6> and its reissdences  <1> 

