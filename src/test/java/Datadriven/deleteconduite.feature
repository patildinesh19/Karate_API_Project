# feature file is describe about callonce method to call mentioned feature file with tagged
# scenario with once and use response vales to execute other scenarious in same feature file
Feature: Verify Delete functionlity

  Background: define base url and get added article details
    Given url baseurlconduit
    * def articledetails = callonce read("data_driven_conduit.feature@addarticle")
    * def titleofarticle = articledetails.title
    * print 'added articles are' ,titleofarticle

  Scenario: Delete Article and verify status and message
    Given path 'articles/', titleofarticle
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+ accesstoken1)'}
    When method delete
    Then status 204

  Scenario: verify deleted article using get request
    Given path 'articles/', titleofarticle
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+ accesstoken1)'}
    And method get
    Then status 404
    * print response
    * match response.errors.article[0] contains 'not found'
