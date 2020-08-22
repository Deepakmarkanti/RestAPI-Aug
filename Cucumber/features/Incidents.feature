Feature: Create new incident using API

Background:
Given setup the base URI for incident api 
And setup the basic authentication with valid credentials 


Scenario Outline: Create new incident by passing data file


And pass the data file <files> in the body
When place the post request
Then verify the status code as 201 

Examples:
|files|
|data.json|
|data1.json|



Scenario: get all incident

When place the get request 
Then verify the status code as 200







