<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>JSTL redirect</title>
</head>

<body>

    <c:url var="url" value="https://search.naver.com/search.naver">
        <c:param name="query" value="설현" />
        <c:param name="where" value="nextearch" />
        <c:param name="sm" value="top_hty" />
        <c:param name="fbm" value="1" />
    </c:url>

    <c:redirect url="${url}" />



</body>
</html>
