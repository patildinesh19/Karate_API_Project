Feature: Add Article using Poojo Class
Background: define base url from config file
    Given url baseurlconduit
    * def datagenerator = Java.type('helper.readexcelandcreatejsonobject')
    #* def datagenerator1 = datagenerator.getvaluefromqueryandconvertintojson("AddArticle")
    * def articlerequestbody = read("classpath:helper/addarticle.json")
   # * print 'title' , datagenerator1.addarticlejson().title
    * set articlerequestbody.article.title = datagenerator.addarticlejson().title
    * set articlerequestbody.article.description = datagenerator.addarticlejson().description
    * set articlerequestbody.article.body = datagenerator.addarticlejson().body
    * set articlerequestbody.article.tagList[0] = datagenerator.addarticlejson().tagList1
    * set articlerequestbody.article.tagList[1] = datagenerator.addarticlejson().tagList2    
    
    
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
