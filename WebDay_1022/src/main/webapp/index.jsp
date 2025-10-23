<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="name" value="aaaaa" />

	name : <c:out value="${name}" /><br>
	name : ${name} <br>
	
	tot : ${tot }
	<c:forEach var="index" begin="1" end="10">
		i=<c:out value="${index }" /><br>
	</c:forEach>
	
	<c:if test="${tot>=70 }">Pass</c:if>
	<c:if test="${empty tot}">NoPass</c:if>
	
</body>
</html>