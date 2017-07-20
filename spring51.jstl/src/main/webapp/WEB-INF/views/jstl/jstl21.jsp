<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>JSTL foreach문</title>
</head>

<body>
    <c:forEach var="cnt" begin="1" end="10" step="1">
        <font size="${cnt}"> ${cnt } 야~호~</font>
        <br>
    </c:forEach>

    <c:forEach var="cnt" begin="2" end="20" step="2">
        <font size="${cnt/2}"> ${cnt/2} 야~호~</font>
        <br>
    </c:forEach>
</body>
</html>
