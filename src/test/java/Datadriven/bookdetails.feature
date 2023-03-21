#Feature file is describe about how to call java class and use faker dependancy create random values in java
# class file and use thoes values in data driven scenarious
Feature: verify book store services

  Background: set base url and call java class file
    Given url 'http://216.10.245.166/'
    * def datagenerator = Java.type('helper.dummydatagenerator')

  Scenario Outline: Add book <book_Name>
    * def bookname = datagenerator.generatebookname()
    * print 'Book Name is : ', bookname
    * def authorname = datagenerator.genratebookauthorname()
    * print 'Book author name is :', authorname
    * def random_aisle_value = datagenerator.generaterandominteger()
    * print 'random_aisle_value ::' , random_aisle_value
    Given path 'Library/Addbook.php'
    And headers {Content-Type:'application/json' ,Accept:'application/json'}
    And request {"name":'#(book_Name)',"isbn":'#(isbn_value)',"aisle":'#(aisle_value)',"author":'#(author)'}
    When method post
    Then status <status>

    Examples: 
      | book_Name | isbn_value | aisle_value        | author     | status |
      | bookname  | aaaa       | random_aisle_value | authorname |    200 |
      | bookname  | aaaa       | random_aisle_value | authorname |    200 |

  Scenario: Get book details by authore
    Given path 'Library/GetBook.php'
    And headers {Content-Type:'application/json' ,Accept:'application/json'}
    And params {AuthorName:ganesh.thakur}
    When method GET
    Then status 200
    * print response
