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
				<h2 class="title">참가자(지원자) 정보 검색</h2>
					<table>
						<tr>
							<td>참가번호</td>
							<td><input type="text" name=""></td>
						</tr>
						<tr>
							<td colspan="2" class="btn_group">
								<input type="button" value="검색하기">
								<input type="button" value="취소하기">
							</td>
						</tr>						
					</table>
				<h2 class="title">참가자(지원자) 정보 조회 결과</h2>	
					<table>
						<tr>
							<td>참가번호</td>
							<td>A001</td>
						</tr>
						<tr>
							<td>참가자명</td>
							<td>김스타</td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td>1997년01월01일</td>
						</tr>
						<tr>
							<td>성별</td>
							<td>여성</td>
						</tr>
						<tr>
							<td>특기</td>
							<td>댄스</td>
						</tr>
						<tr>
							<td>소속사</td>
							<td>A엔터테인먼트</td>
						</tr>
					</table>
				<h2 class="title">참가자(지원자) 정보 조회 결과</h2>	
					<table>
						<tr>
							<td colspan="2" align=center>등록된 정보가 없습니다</td>
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