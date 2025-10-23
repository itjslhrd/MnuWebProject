<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:set var="a" value="70" />
<c:set var="name" value="김학생" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	점수 : ${a + 50 } <br><br><br>
	이름 : ${name} <br>
	이름 : <c:out value="${name }"></c:out>
	
	<c:if test="${a>=80}">
		Pass입니다
	</c:if>
	<c:if test="${a<80}">
		NoPass입니다
	</c:if>
	<br>
	<c:forEach var="i" begin="1" end="10" step="2">
		i = ${i}<br>
	</c:forEach>
</body>
</html>