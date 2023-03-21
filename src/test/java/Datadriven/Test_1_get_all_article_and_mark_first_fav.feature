Feature: get all article and mark first article as favorite then verify favoritesCount for first article

  Background: get all article and store first article slug and favoritesCount
    Given url baseurlconduit
    And path 'articles'
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    And params {limit: 10, offset: 0}
    When method Get
    Then status 200
    And print response
    * def firstarticleslug = response.articles[0].slug
    * def username = response.articles[0].author.username
    * def intial_favoritesCount = response.articles[0].favoritesCount

  Scenario: mark first article as favorite and verify favoritesCount should be increase by one
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
    * match current_favoritesCount == intial_favoritesCount + 1

  Scenario: verify favorite article is present on user proflie
    Given url baseurlconduit
    And path '/articles'
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    And params {favorited: '#(username)', limit: 10, offset: 0}
    When method get
    Then status 200
    And print response
    * match response.articles[0].slug == firstarticleslug
