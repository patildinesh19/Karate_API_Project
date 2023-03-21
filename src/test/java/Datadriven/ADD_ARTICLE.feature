o# feature file decrible about post request and pass request body using external json file

Feature: create Article by passing paylod using external addarticle.json file

  Background: define base url from config file
    Given url baseurlconduit
    * def datagenerator = Java.type('helper.dummydatagenerator')
    * def articlerequestbody = read("classpath:helper/addarticle.json")
    * set articlerequestbody.article.title = datagenerator.generatearticle().title
    * set articlerequestbody.article.description = datagenerator.generatearticle().description
    * set articlerequestbody.article.body = datagenerator.generatearticle().body
@addarticle
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
