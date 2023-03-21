Feature: Add Article using Poojo Class
Background: define base url from config file
    Given url baseurlconduit
    * def datagenerator = Java.type('helper.readexcelandcreatejsonfile')
    * def dbresult = datagenerator.addarticlejson()
    * def articlerequestbody = read("classpath:helper/addarticle_1.json")
    
    
  Scenario: create a new Article with title      
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
