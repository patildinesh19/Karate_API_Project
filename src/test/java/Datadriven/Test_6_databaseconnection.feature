Feature: Karate integration with database

  Background: 
    * def dbdata = Java.type('helper.SQLDatabaseConnection')

  Scenario: send data with new job
    * eval dbdata.executeinserquery("015","Faisal")

  Scenario: send data with new job
    * def dbresult = dbdata.getvaluefromqueryandconvertintojson("Dinesh")
    * print 'ID --' ,dbresult.ID
    * print 'Emp_Name --' ,dbresult.EMP_NAME
    * print 'Emp_address --' ,dbresult.EMP_Address
    * print 'Emp_phonenumber --' ,dbresult.EMP_PHONE
    * print 'Dept_No --' ,dbresult.Dept_No
    * print 'Dept_Name --' ,dbresult.Dept_Name
    * print 'Salary --' ,dbresult.Salary
