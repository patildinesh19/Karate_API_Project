# feature file describe about how to call external json file and how to auto udate json values using
# java class
Feature: call ADD_ARTICLE.feature file and udate added article values using external
  updatearticle.json file with auto udate using java class and mark article as favorite

  Background: 
    Given url baseurlconduit
    * def datagenerator = Java.type('helper.dummydatagenerator')
    * def uparticlerequestbody = read("classpath:helper/updatearticle.json")
    * set uparticlerequestbody.article.title = datagenerator.generatearticle().title
    * set uparticlerequestbody.article.description = datagenerator.generatearticle().description
    * set uparticlerequestbody.article.body = datagenerator.generatearticle().body
    * set uparticlerequestbody.article.tagList[0] = datagenerator.generatearticle().tagList
    * set uparticlerequestbody.article.tagList[1] = datagenerator.generatearticle().tagList
    * def articledetails = callonce read("ADD_ARTICLE.feature@addarticle")
    * def slug = articledetails.title
    * print 'slug for update article is:' , slug
    * set uparticlerequestbody.article.slug = '#(slug)'

  Scenario: mark favorite article
    #pass variable in path parameter
    And path 'articles/'+slug+'/favorite'
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
    #pass empty request body
    And request {}
    When method post
    Then status 200
    And print response
    And match response.article.favorited == true

  Scenario: update Article
    Given path 'articles/' ,slug
    And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+ accesstoken1)'}
    And request uparticlerequestbody
    When method put
    Then status 200
