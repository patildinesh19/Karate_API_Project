Feature: get first article, add comment to article
  and verify comment of article 
  then delte the article and verify comment is deleted 

  Background: get first article from all article
    Given url baseurlconduit
    * def datagenerator = Java.type('helper.dummydatagenerator')
    * def articlerequestbody = read("classpath:helper/addarticle.json")
    * set articlerequestbody.comment.body = datagenerator.addcomments().body
    And path 'articles'
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    And params {limit: 10, offset: 0}
    When method Get
    Then status 200
    And print response
    * def firstarticleslug = response.articles[0].slug
    * def username = response.articles[0].author.username
    * def intial_favoritesCount = response.articles[0].favoritesCount

  Scenario: verify Initial comment count is Null
    Given url baseurlconduit
    And path 'articles/'+firstarticleslug+'/comments'
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    When method get
    Then status 200
    And print response
    And response.comments == '#[10]'
@addcomments
  Scenario: add comment on article and verify added comments
    Given url baseurlconduit
    And path 'articles/'+firstarticleslug+'/comments'
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    And request articlerequestbody
    When method post
    Then status 200
    Then print response
    * def commentid = response.comment.id
    * def comment = response.comment.body
   
  Scenario: add blank comment on article and verify error message and response
    Given url baseurlconduit
    And path 'articles/'+firstarticleslug+'/comments'
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    And request {	"comment": {		"body": ""	}}
    When method post
    Then status 422
    And print response
    And match response.errors.body[0] contains "can't be blank"
