<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>JSTL fmt</title>
</head>

<body>

<fmt:formatNumber value="0.02" type="currency" currencySymbol="원"/>
<br>
<fmt:formatNumber value="9876543.61" type="number"/>
<br>
<fmt:formatNumber value="9876543.61" type="currency"/>
<br>
<fmt:formatNumber value="9876543.61" type="percent"/>
<br>
[type="{number|currency|percent}"]

<br>

<br>

 
<fmt:parseDate value="${DateString1}" var="noticePostDate" pattern="yyyyMMdd"/>
<fmt:formatDate value="${noticePostDate}" pattern="yyyy.MM.dd"/>
<br>
<fmt:formatDate value="${DateString2}" pattern="yyyy.MM.dd"/>


</body>
</html>
