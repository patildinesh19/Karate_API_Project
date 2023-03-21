# Featue file describe about data driven testing using example keyword , how to pass variable in path parameter
# how set empty request body, how to verify status using variable
Feature: conduit application using data driven

  Background: define base url from config file
    Given url baseurlconduit

  @addarticle
  Scenario Outline: create a new Article with title <title>
    And path 'articles/'
    And print 'Access token is :' ,accesstoken1
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    And request {"article": {"tagList": ['#(taglist)'],"title": '#(title)',"description": '#(description)',"body": '#(body)'}}
    When method Post
    Then status <status>
    * def title = response.article.slug
    * print response
    * print 'Title ::', title

    Examples: 
      | title              | taglist | description                           | body              | status |
      | ManualTesting      | QA      | Manual testing with black box testing | Black box testing |    200 |
      | Automation Testing | QA      | Automation testing with selenium      | Selenium Testing  |    200 |

  Scenario Outline: mark favorite article <title>
    #pass variable in path parameter
    And path 'articles/<title>/favorite'
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    #pass empty request body
    And request {}
    When method post
    Then status <status>
    And print response
    And match response.article.favorited == true

    Examples: 
      | title                    | status |
      | Automation-Testing-99869 |    200 |
      | ManualTesting-99869      |    200 |

  Scenario: navigate to Profile page and verify Profile
    Given path '/profiles/' ,userdetails
    When method Get
    Then status 200
    And print response
    #match variable value with response value
    And match response.profile.username contains '#(userdetails)'
