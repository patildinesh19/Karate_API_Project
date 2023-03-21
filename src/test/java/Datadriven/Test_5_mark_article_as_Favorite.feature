Feature: mark article as favorite
Background: 
Given url baseurlconduit
Scenario: mark first article as favorite
    Given url baseurlconduit
    And path 'articles/'+firstarticleslug+'/favorite'
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    #pass empty request body
    And request {}
    When method post
    Then status 200
    And print response
    And match response.article.favorited == true
    * def current_favoritesCount = response.article.favoritesCount
    