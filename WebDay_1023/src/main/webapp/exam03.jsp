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
	<table border="1">
		<tr>
			<td>이름</td>
		</tr>
	<c:if test="${empty aList}">
		<tr>
			<td> 등록된 이름 없음</td>
		</tr>	
	</c:if>	
	<c:forEach var="na" items="${aList}">	
		<tr>
			<td> ${na}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>