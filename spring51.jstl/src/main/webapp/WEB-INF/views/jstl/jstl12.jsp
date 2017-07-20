<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>JSTL choose문</title>
</head>

<body>
    <h3>jstl 연속 if(choose) 사용법</h3>
    <c:out value="${param.num }"></c:out>
    <br>
    <c:choose>

        <c:when test="${param.num == 0 }">
            param.num == 0 : 처음 뵙겠습니다.<br>
        </c:when>
        <c:when test="${param.num <= 3 }">
            ${param.num} : 123처음 뵙겠습니다.<br>
        </c:when>
        <c:otherwise>
            c:otherwise : 안녕하세요.<br>
        </c:otherwise>
    </c:choose>

</body>
</html>
