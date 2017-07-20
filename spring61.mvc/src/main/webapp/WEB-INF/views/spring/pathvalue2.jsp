<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>
<c:if test = "${phone == '1244'}">  
    if가 1244일 경우 출력<br>
</c:if>
<c:if test = "${phone == '1'}">  
    if가 1일 경우 출력<br>
</c:if>
<c:choose>
    <c:when test="${phone != null}">
    if가 null이 아닐 경우 출력<br>
    </c:when>
    <c:otherwise>
    c:otherwise : 안녕하세요.<br>
    </c:otherwise>
</c:choose>
    
    <p><h1> ${name}</h1></p>
    <p><h1> ${phone}</h1></p>
            
            
            
</body>
</html>

