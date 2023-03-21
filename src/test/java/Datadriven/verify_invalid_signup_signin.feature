Feature: Verify Failed login scenarious

  Scenario: Verify Invalid credentials
    Given url baseurlconduit
    And path 'users/login'
    And request {"user": {"email": 'DINESH.PATIL@GMAIL.COM',"password": 'TEST@123'}}
    When method Post
    Then status 403
    And print response

  Scenario: Signup with valid credentials
    Given url baseurlconduit
    And path 'users'
    And request {user: {email: "patildinesh19@gmail.com", password: "DD123@dd123", username: "dineshthakur19"}}
    When method Post
    Then status 422
    And print response
    * match response.errors.email[0] contains 'has already been taken'
    * match response.errors.username[0] contains 'has already been taken'
