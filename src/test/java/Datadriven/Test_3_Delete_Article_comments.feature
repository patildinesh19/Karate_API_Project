Feature: delete article comment and verify it is delted or not
Background:
 Given url baseurlconduit
  * def articledetails = callonce read("Test_2_verify_fav_article_on_user_profile.feature@addcomments")
  * def commentidfordelete = articledetails.commentid
  * def commentfordelete = articledetails.comment
  * def articlename = articledetails.firstarticleslug 
  
 Scenario: delete comments sucessfully
 Given path 'articles/'+articlename+'/comments/' ,commentidfordelete
 And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
 When method delete
 Then status 200
 
  Scenario: verify deleted comments
 Given path 'articles/'+articlename+'/comments/'
 And headers {Accept: 'application/json' ,Authorization:'#("Bearer "+accesstoken1)'}
 When method delete
 Then status 404
 

 
 
