<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    
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
	.content table th, td{border:1px solid #bbb;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}
</style>
</head>
<body>
	<div class="header">
		<header>
			<h1 class="logo">인사관리 시스템  Ver 2.0</h1>
			<div class="nav">
				<nav>
					<ul>
						<li><a href="student_write.do">학생등록</a></li>
						<li><a href="student_list.do">전체학생조회</a></li>
						<li><a href="score_write.do">성적등록</a></li>
						<li><a href="score_list.do">전체학생성적조회</a></li>
						<li><a href="student_score_list.do">학생성적조회</a></li>
						<li><a href="index.html">홈으로</a></li>
					</ul>
				</nav>			
			</div>
		</header>
	</div>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">학생 성적 조회</h2>
					<table>
						<tr>
							<td>학번</td>
							<td>국어</td>
							<td>영어</td>
							<td>수학</td>
							<td>총점</td>
							<td>평균</td>
						</tr>
			<c:if test="${dto.hakbun != null}">		
						<tr>
							<td>${dto.hakbun}</td>
							<td>${dto.kor}</td>
							<td>${dto.eng}</td>
							<td>${dto.mat}</td>
							<td>${dto.tot}</td>
							<td>${dto.ave}</td>
						</tr>
			</c:if>	
			<c:if test="${dto.hakbun == null}">		
						<tr>
							<td colspan="6">등록된 정보가 없음</td>
						</tr>
			</c:if>			
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