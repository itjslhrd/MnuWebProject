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
				<h2 class="title">오디션 지원자 등록</h2>
				<form name="" method="" action="">
					<table>
						<tr>
							<td>참가번호</th>
							<td><input type="text" name=""> * 참가번호는(A000)4자리 입니다</td>
						</tr>
						<tr>
							<td>참가자명</td>
							<td><input type="text" name="" ></td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td>
								<input type="text" name="" size=4>년
								<input type="text" name="" size=4>월
								<input type="text" name="" size=4>일
							</td>
						</tr>
						<tr>
							<td>성별</td>
							<td>
								<input type="radio" name="" >남성
								<input type="radio" name="" >여성
							</td>
						</tr>
						<tr>
							<td>특기</td>
							<td>
								<select name="">
									<option>특기선택</option>
									<option >댄스</option>
									<option >랩</option>
									<option >노래</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>소속사</td>
							<td><input type="text" name=""></td>
						</tr>			
						<tr>
							<td colspan="2" class="btn_group">
								<input type="button" value="오디션록" >
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