# feature file is use for create Authontication token and save token in karate.feature.js file
# and use that token in all other feature files.
Feature: Create new user for conduite application without hardcoding the values

  Scenario: create valid user account for conduit application
    Given url baseurlconduit
    And path 'users/login'
    And request {email: 'mangeshtestgh123@gmail.com', password: "Test@123", username: '#(randomname)'}
    When method Post
    Then status 200
    And print response
    * def token = response.user.token
    * def username = response.user.username
    * print 'USERNAME is ==>' ,username
    * print 'TOKEN ==>: ', token
