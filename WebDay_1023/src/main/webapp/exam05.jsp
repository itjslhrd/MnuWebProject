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
	<table border="1" width="500">
		<tr>
			<td>번호</td><td>이름</td><td>성별</td><td>점수</td><td>학점</td>
		</tr>
<c:if test="${empty pList}">
		<tr>
			<td colspan="5">등록된 자료가 없음</td>
		</tr>
</c:if>		
<c:set var="tot" value="0"></c:set>
<c:forEach var="dto" items="${pList}">
	<c:set var="tot" value="${tot + dto.score}" />
		<tr>
			<td>${dto.bun}</td>
			<td>${dto.name}</td>
			<td>
				<c:if test="${dto.gender=='M'}">남자</c:if>
				<c:if test="${dto.gender=='F'}">여자</c:if>
			</td>
			<td>${dto.score}</td>
			<td>
				<c:choose>
					<c:when test="${dto.score>=90}">A</c:when>
					<c:when test="${dto.score>=80}">B</c:when>
					<c:when test="${dto.score>=70}">C</c:when>
					<c:when test="${dto.score>=60}">D</c:when>
					<c:otherwise>F</c:otherwise>
				</c:choose>
			</td>
		</tr>
</c:forEach>	
		<tr>
			<td colspan="3">합계</td><td colspan="2">${tot}</td>
		</tr>
	
	</table>
</body>
</html>