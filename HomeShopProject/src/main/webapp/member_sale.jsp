<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!-- 변수, 제어, 반복 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!-- 문자열처리 -->  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!-- 숫자,날자 formating -->    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo {color:#fff; text-align:center; background-color:#0040FF; padding:16px 0;}
	.nav{padding:12px 0; overflow:hidden;background-color:#BCA9F5;}
	.nav ul,li{float:left; padding:0 20px; text-align:center;}
	.content {background-color:#E6E6E6; padding:16px;}
	.title {text-align:center;padding:22px;}
	.content table{width:700px;margin:0 auto;}
	.content table th, td{border:1px solid #bbb;padding: 0 0 0 5px;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}
</style>
</head>
<body>
	<div class="header">
		<header>
			<h1 class="logo">홈쇼핑 관리 시스템  Ver 1.0</h1>
			<div class="nav">
				<nav>
					<ul>
						<li><a href="member_write.do">회원등록</a></li>
						<li><a href="member_list.do">회원목록조회</a></li>
						<li><a href="member_sale.do">회원매출조회</a></li>
						<li><a href="member_search.do">회원정보검색</a></li>
						<li><a href="index.html">홈으로</a></li>
					</ul>
				</nav>			
			</div>
		</header>
	</div>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">회원 매출 조회</h2>
					<table>
						<tr>
							<td>회원번호</td>
							<td>회원성명</td>
							<td>전화번호</td>
							<td>고객등급</td>
							<td>매출</td>
						</tr>
				<c:forEach var="dto" items="${list}">		
					<c:set var="total" value="${total + dto.tot}" />	
						<tr>
							<td>${dto.custno}</td>
							<td>${dto.custname}</td>
							<td>${dto.phone}</td>
						<c:choose>
							<c:when test="${dto.grade=='A'}"><td>VIP</td></c:when>	
							<c:when test="${dto.grade=='B'}"><td>일반</td></c:when>	
							<c:when test="${dto.grade=='C'}"><td>직원</td></c:when>								
						</c:choose>							
							<td><fmt:formatNumber value="${dto.tot}" type="number" />   </td>
						</tr>
				</c:forEach>		
						<tr>
							<td colspan="4" style="text-align:center">총매출액</td>
							<td><fmt:formatNumber value="${total}" type="number" /></td>
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