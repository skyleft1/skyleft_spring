<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>JSTL 변수 선언</title>
</head>

<body>
    <h1>JSTL url query string 처리</h1>
    <hr>
    상품코드 : ${param.code}
    <br> 상품명 : ${param.name}
    <br> 가격 : ${param.price}원
    <br> 브라우저 : ${param.browser}
    <br>

</body>
</html>
