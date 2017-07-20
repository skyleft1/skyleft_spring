<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href ='/el/el01' target='_blank'>el01</a><br>
<a href ='/el/el02' target='_blank'>el02</a><br>
<a href ='/el/el03?id=pinksung' target='_blank'>el03</a><br>

</body>
</html>
