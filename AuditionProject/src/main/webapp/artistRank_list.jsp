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
				<h2 class="title">참가자 등수 조회</h2>
					<table>
						<tr>
							<td>참가번호</th>
							<td>참가자명</td>
							<td>성별</td>
							<td>총점</td>
							<td>평균</td>
							<td>등수</td>
						</tr>
						<tr>
							<td>A004</th>
							<td>정스타</td>
							<td>남성</td>
							<td>284</td>
							<td>94.67</td>
							<td>1</td>
						</tr>
						<tr>
							<td>A003</th>
							<td>왕스타</td>
							<td>남성</td>
							<td>270</td>
							<td>90.00</td>
							<td>2</td>
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