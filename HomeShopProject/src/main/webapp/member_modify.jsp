<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
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
	.content table{width:500px;margin:0 auto;}
	.content table th, td{border:1px solid #bbb;padding: 0 0 0 5px;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}
</style>
<script>
	function member_send(){
		//유효성 검사
		
		member.submit();// 전송		
	}
	
	function test(){
		history.back();
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
				<h2 class="title">회원 수정</h2>
				<form name="member" method="post" action="member_modify.do">
					<table>
						<tr>
							<td>회원번호(자동생성)</th>
							<td><input type="text" name="custno" readonly value="${dto.custno}"></td>
						</tr>
						<tr>
							<td>회원성명</td>
							<td><input type="text" name="custname" readonly value="${dto.custname}"></td>
						</tr>
						<tr>
							<td>회원전화</td>
							<td>
								<input type="text" name="tel1" size=3 value="${fn:substring(dto.phone,0,3)}">-
								<input type="text" name="tel2" size=4 value="${fn:substring(dto.phone,4,8)}">-
								<input type="text" name="tel3" size=4 value="${fn:substring(dto.phone,9,13)}">
							</td>
						</tr>
						<tr>
							<td>회원성별</td>
							<td>
								<input type="radio" name="gender" value="M" <c:if test="${dto.gender=='M'}"> checked </c:if>>남성
								<input type="radio" name="gender" value="F" <c:if test="${dto.gender=='F'}"> checked </c:if>>여성
							</td>
						</tr>
						<tr>
							<td>가입일자</td>
							<td><input type="text" name="joindate" value="${dto.joindate}"></td>
						</tr>			
						<tr>
							<td>고객등급</td>
							<td>
								<select name="grade">
									<option>고객등급</option>
									<option value="A" <c:if test="${dto.grade=='A'}"> selected </c:if>>VIP</option>
									<option value="B" <c:if test="${dto.grade=='B'}"> selected </c:if>>직원</option>
									<option value="C" <c:if test="${dto.grade=='C'}"> selected </c:if>>일반</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>도시코드</td>
							<td><input type="text" name="city" value="${dto.city}"></td>
						</tr>			
						<tr>
							<td colspan="2" class="btn_group">
								<input type="button" value="수정하기" onclick="member_send()">
								<input type="button" value="돌아가기" onclick="test()">
							</td>
						</tr>
					</table>
				</form>
					
	
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