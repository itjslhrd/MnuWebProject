<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet">

</head>
<body>
	<div class="header">
		<header>
			<h1 class="logo">고교 성적 관리 프로그램  Ver 1.0</h1>
			<div class="nav">
				<nav>
					<c:import url="/include/header.jsp"></c:import>
				</nav>			
			</div>
		</header>
	</div>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">학생 정보 조회</h2>
					<table>
						<tr>
							<td>학년-반-번호</th>
							<td>이름</td>
							<td>생년월일</td>
							<td>성별</td>
							<td>전화</td>
						</tr>
			<c:forEach var="dto" items="${list}">			
						<tr>
							<td><a href="student_modify.do?syear=${dto.syear}&sclass=${dto.sclass}&sno=${dto.sno}">${dto.syear}-${dto.sclass}-${dto.sno}</a></th>
							<td><a href="student_modify.do?syear=${dto.syear}&sclass=${dto.sclass}&sno=${dto.sno}">${dto.sname}</a></td>
							<td>${dto.birth}</td>
							<td>${dto.gender}</td>
							<td>${dto.tel1}-${dto.tel2}-${dto.tel3}</td>
						</tr>
			</c:forEach>			
					</table>
			</div>
		</section>
	</div>
	<div class="footer">
		<footer>
			<p>HRDKOREA Copyright@2016 All rights reserve. Human Resources 
			Development Serivce of Korea</p>
		</footer>
	</div>
</body>
</html>