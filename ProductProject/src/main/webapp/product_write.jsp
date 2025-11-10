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
			<h1 class="logo">물류창고 입출고 프로그램  Ver 1.0</h1>
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
				<h2 class="title">제품 등록</h2>
				<form name="" method="" action="">
					<table>
						<tr>
							<td>제품코드</th>
							<td><input type="text" name=""> 예) B01</td>
						</tr>
						<tr>
							<td>제품명</th>
							<td><input type="text" name=""></td>
						</tr>
						<tr>
							<td>사이즈</th>
							<td><input type="text" name="" ></td>
						</tr>
						<tr>
							<td>매입단가</td>
							<td><input type="text" name="" ></td>
						</tr>
						<tr>
							<td>출고단가</td>
							<td>
								<input type="text" name="">
							</td>
						</tr>
						<tr>
							<td colspan="2" class="btn_group">
								<input type="button" value="제품등록" >
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