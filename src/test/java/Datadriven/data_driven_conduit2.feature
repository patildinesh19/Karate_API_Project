# Featue file describe about data driven testing using example keyword , how to pass variable in path parameter
# how set empty request body, how to verify status using variable
Feature: conduit application using data driven

  Background: define base url from config file
    Given url baseurlconduit
    * def tesdata = read("payload.xlsx")

  @addarticle
  Scenario Outline: create a new Article with title <title>
    And path 'articles/'
    And print 'Access token is :' ,accesstoken1
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    And request {"article": {"tagList": ['#(tagList_1)','#(tagList_2)'],"title": '#(title)',"description": '#(description)',"body": '#(body)'}}
    When method Post
    Then status <status>
    * def title = response.article.slug
    * print response
    * print 'Title ::', title

    Examples: 
      |tesdata|
 