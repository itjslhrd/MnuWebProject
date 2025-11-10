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
				<h2 class="title">성적 입력</h2>
				<form name="" method="" action="">
					<table>
						<tr>
							<td>학년</th>
							<td><input type="text" name="" size="2"> 예) 1</td>
						</tr>
						<tr>
							<td>반</th>
							<td><input type="text" name="" size="2"> 예) 01</td>
						</tr>
						<tr>
							<td>번호</th>
							<td><input type="text" name="" size="2"> 예) 01</td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type="text" name="" ></td>
						</tr>
						<tr>
							<td>국어</td>
							<td>
								<input type="text" name=""> 정수범위(1~100)
							</td>
						</tr>
						<tr>
							<td>영어</td>
							<td>
								<input type="text" name=""> 정수범위(1~100)
							</td>
						</tr>
						<tr>
							<td>수학</td>
							<td>
								<input type="text" name=""> 정수범위(1~100)
							</td>
						</tr>
						<tr>
							<td colspan="2" class="btn_group">
								<input type="button" value="성적등록" >
								<input type="button" value="다시쓰기" >
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