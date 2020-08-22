Feature: Get all change request using API

Background:
Given setup the base URI for change_request api 
And setup the basic authentication with valid credentials 


Scenario: Get all change request from service now

When place the get request
Then verify the status code as 200








