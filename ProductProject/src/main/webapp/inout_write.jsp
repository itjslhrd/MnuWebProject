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
				<h2 class="title">입출고 등록</h2>
				<form name="inout" method="post" action="inout_write.do">
					<table>
						<tr>
							<td>입출고번호</th>
							<td><input type="text" name="t_no" value="${t_no}"> 예) 20200006</td>
						</tr>
						<tr>
							<td>제품코드</th>
							<td><input type="text" name="p_code"> 예) B01</td>
						</tr>
						<tr>
							<td>입출고구분</th>
							<td>
								<input type="radio" name="t_type" value="I" checked>입고
								<input type="radio" name="t_type" value="O">출고
							</td>
						</tr>
						<tr>
							<td>수량</th>
							<td><input type="text" name="t_cnt" ></td>
						</tr>
						<tr>
							<td>거래일자</td>
							<td><input type="text" name="t_date" ></td>
						</tr>
						<tr>
							<td>거래처</td>
							<td>
								<select name="c_code">
									<option>거래처명</option>		
								<c:forEach var="dto" items="${list}">								
									<option value="${dto.c_code }"    >${dto.c_name}</option>
								</c:forEach>										
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="btn_group">
								<input type="button" value="입출고등록" onClick="inout_send()" >
								<input type="button" value="다시쓰기" onClick="inout_reset()">
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