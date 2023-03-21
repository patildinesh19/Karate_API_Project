Feature: verify valid login details for application

  Scenario: verify valid credentials
    Given url baseurlconduit
    And path 'users/login'
    And request {"user": {"email": '#(email)',"password": '#(password)'}}
    When method Post
    Then status 200
    And print response
    * def token = response.user.token
    * def username = response.user.username
    * print 'USERNAME is ==>' ,username
    * print 'TOKEN ==>: ', token
