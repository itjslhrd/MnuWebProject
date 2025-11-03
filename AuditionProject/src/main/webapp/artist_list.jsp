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
			<!-- 
			<%@ include file="/include/header.jsp" %>
			 -->
			<c:import url="/include/header.jsp"></c:import>
		</header>
	</div>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">참가자 목록 조회</h2>
					<table>
						<tr>
							<td>참가번호</th>
							<td>참가자명</td>
							<td>생년월일</td>
							<td>성별</td>
							<td>특기</td>
							<td>소속사</td>
						</tr>
						<tr>
							<td>A001</th>
							<td>김스타</td>
							<td>1997년01월01일</td>
							<td>여성</td>
							<td>댄스</td>
							<td>A엔터테인먼트</td>
						</tr>
						<tr>
							<td>A002</th>
							<td>조스타</td>
							<td>1998년02월01일</td>
							<td>남성</td>
							<td>노래</td>
							<td>B엔터테인먼트</td>
						</tr>			
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