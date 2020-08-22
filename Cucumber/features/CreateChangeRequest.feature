Feature: Create new change request using API

Background:
Given setup the base URI for change_request api 
And setup the basic authentication with valid credentials 


Scenario Outline: Create new change request by passing data file

And pass the data file <files> in the body
When place the post request
Then verify the status code as 201 

Examples:
|files|
|data.json|
|data1.json|









