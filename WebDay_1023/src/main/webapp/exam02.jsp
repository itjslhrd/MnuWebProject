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
	<h3>exam02.jsp</h3>
	점수 : ${score } <br>
	이름 : ${name } <br>
	판정 : <c:if test="${score>=80 }">Pass</c:if>
		  <c:if test="${score<80 }">NoPass</c:if>
</body>
</html>