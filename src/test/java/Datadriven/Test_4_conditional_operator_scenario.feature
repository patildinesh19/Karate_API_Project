Feature: use if condtion to make articale count should be 1

  Background: 
    Background: get all article and store first article slug and favoritesCount

    Given url baseurlconduit

  Scenario: Get all Article and favoritesCount for first article if count is 0 then call add favorites scenario
    And path 'articles'
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    And params {limit: 10, offset: 0}
    When method Get
    Then status 200
    And print response
    * def firstarticleslug = response.articles[0].slug
    * def username = response.articles[0].author.username
    * def intial_favoritesCount = response.articles[0].favoritesCount
    # if statment
    
    # * if (intial_favoritesCount == 0) karate.call("Test_5_mark_article_as_Favorite.feature", { firstarticleslug : firstarticleslug })
  
    # if statment using javscript
   
   # * def result = intial_favoritesCount == 0 ? karate.call("Test_5_mark_article_as_Favorite.feature", { firstarticleslug : firstarticleslug }).current_favoritesCount : intial_favoritesCount
   
    #retry
    * configure retry = {count: 10, interval:5000}
    
    #sleep
    * def sleep = function(pause){ java.lang.Thread.sleep(pause) }
    
    Given path 'articles'
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    And params {limit: 10, offset: 0}
    #call retry method before http method
    
    And retry until response.articles[0].favoritesCount ==1
    
    When method Get
    
    # use sleep method after https request    
    * eval sleep(5000)
    Then status 200
    And print response
   # * print 'RESULT::' ,result
   # * match response.articles[0].favoritesCount == result
