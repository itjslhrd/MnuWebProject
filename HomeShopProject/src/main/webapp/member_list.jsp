<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

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
				<h2 class="title">회원 목록 조회</h2>
					<table>
						<tr>
							<td>회원번호</td>
							<td>회원성명</td>
							<td>전화번호</td>
							<td>성별</td>
							<td>가입일자</td>
							<td>고객등급</td>
							<td>거주지역</td>
						</tr>
				<c:if test="${empty list}">
						<tr>
							<td colspan="7">등록된 자료가 없음</td>
						</tr>			
				</c:if>
				<c:forEach var="dto" items="${list}">
						<tr>
							<td>${dto.custno}</td>
							<td>${dto.custname}</td>
							<td>${dto.phone}</td>
						<c:if test="${dto.gender=='M'}">
							<td>남자</td>
						</c:if>
						<c:if test="${dto.gender=='F'}">
							<td>여자</td>
						</c:if>							
							<td>${dto.joindate}</td>
						<c:choose>
							<c:when test="${dto.grade=='A'}"> <c:set var="grade" value="VIP" /> </c:when>
							<c:when test="${dto.grade=='B'}"> <c:set var="grade" value="일반" /> </c:when>
							<c:when test="${dto.grade=='C'}"> <c:set var="grade" value="직원" /> </c:when>
						</c:choose>	
							<td>${grade}</td>
							<td>${dto.city}</td>
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