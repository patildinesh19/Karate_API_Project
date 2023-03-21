Feature: test performance testing
  Background: define base url from config file
    Given url baseurlconduit
    * def datagenerator = Java.type('helper.dummydatagenerator')
    * def articlerequestbody = read("classpath:helper/addarticle.json")
    * set articlerequestbody.article.title = __gatling.title
    * set articlerequestbody.article.description = __gatling.description
    * set articlerequestbody.article.body = datagenerator.generatearticle().body

		* def sleep = function(ms) { java.lang.Thread.sleep(ms) }
		* def pause = karate.get('_gatling.pause', sleep)
  Scenario: create a new Article with title and delete and verify it is deleted or not
    And path 'articles/'
    And print 'Access token is :' ,accesstoken1
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    And request articlerequestbody
    When method Post
    Then status 200
    * match response.article.title == articlerequestbody.article.title
    * def title = response.article.slug
    * print response
    * print 'Title ::', title
    * pause(5000)
    
    #Given path 'articles/', title
   # And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+ accesstoken1)'}
   # When method delete
   # Then status 204
   # Given path 'articles/', title
  #  And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+ accesstoken1)'}
   # And method get
  #  Then status 404
   # * print response
    #* match response.errors.article[0] contains 'not found'
    