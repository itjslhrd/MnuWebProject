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
<script>
	function mem_search(){
		if(member.custno.value==""){
			alert("검색할 회원번호를 입력하세요");
			member.cusno.focus();
			return;
		}
		member.submit();
	}
</script>
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
			<c:choose>
				<c:when test="${empty dto}">	
				<h2 class="title">회원 정보 검색</h2>
					<form name="member" method="post" action="member_search.do">
					<table>
						<tr>
							<td>회원번호</td>
							<td><input type="text" name="custno"></td>
						</tr>
						<tr>
							<td colspan="2" class="btn_group">
								<input type="button" value="검색하기" onclick="mem_search()">
								<input type="button" value="취소하기" onclick="history.back()">
							</td>
						</tr>						
					</table>
					</form>
				</c:when>
				<c:when test="${dto.custno != 0}">
				<h2 class="title">회원 정보 조회 결과</h2>	
					<table>
						<tr>
							<td>회원번호</td>
							<td>${dto.custno}</td>
						</tr>
						<tr>
							<td>회원성명</td>
							<td>${dto.custname}</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td>${dto.phone}</td>
						</tr>
						<tr>
							<td>회원성별</td>
							<td>${dto.gender}</td>
						</tr>
						<tr>
							<td>가입일자</td>
							<td>${dto.joindate}</td>
						</tr>
						<tr>
							<td>고객등급</td>
							<td>${dto.grade}</td>
						</tr>
						<tr>
							<td>도시</td>
							<td>${dto.city}</td>
						</tr>
					</table>
				</c:when>
				<c:when test="${dto.custno == 0}">
				<h2 class="title">회원 정보 조회 결과</h2>	
					<table>
						<tr>
							<td colspan="2" align=center>등록된 정보가 없습니다</td>
						</tr>
					</table>
				</c:when>	
			</c:choose>
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