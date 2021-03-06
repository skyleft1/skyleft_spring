<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>  
    <p>  The time on the server is ${serverTime}. </p>
      

    <h2> HomeController </h2> 
    <a href="spring/helloworld" target="_blank">/spring/helloworld</a> <br />
    <a href="spring/sayHello" target="_blank">/spring/sayHello</a> <br />  
    <hr />
    
    <a href="spring/redirect" target="_blank">/spring/helloworld redirect 테스트</a> <br />
    <a href="spring/forward" target="_blank">/spring/helloworld forward 테스트</a> <br />
    <hr>
    
    <a href="spring/querystring?name=test&phone=1244" target="_blank">/spring/querystring?name=test&phone=1244</a> <br />
    <a href="spring/pathvalue/test" target="_blank">/spring/pathvalue/test</a> <br />
    <a href="spring/pathvalue/test/1244" target="_blank">/spring/pathvalue/test/1244</a> <br />
    <hr />
    
    <a href="spring/login" target="_blank">/spring/login</a> <br /> 
    <a href="spring/loginmodel" target="_blank">/spring/loginmodel</a> <br />
    <hr>
    
    <h2> PhoneController </h2> 
    <a href="/phone/writeone" target="_blank">/phone/writeone</a> <br />
    <a href="/phone/writelist" target="_blank">/phone/writelist</a> <br />
    <hr>
    
    <h2> UploadController, DownloadController 만들기 </h2>
    <a href="./upload/fileupload"    target="_blank">./upload/fileupload </a> <br> 
    <a href="./upload/filedownload"  target="_blank">./upload/filedownload </a> <br>
    <hr />
    
    <h2> 테이블의 BLOB,CLOB 컬럼에 이미지 저장하고 가져오기</h2>   
    <a href="./upload/imageupload"   target="_blank">./upload/imageupload </a> <br>
    <a href="./upload/imageview/1"   target="_blank">./upload/imageview/1 </a> <br>
    <hr>
    
    <h2> PersonController </h2>
    <a href="/person/" target="_blank">/person/ </a> <br />  
    <hr>
        
</body>
</html>
