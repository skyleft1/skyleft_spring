<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>
    <label for="dfdf">
        <h2>ID : ${logininfo.id}</h2>
        <h2>PW : ${logininfo.pw}</h2>
    </label>
</body>
</html>
