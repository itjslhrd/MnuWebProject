<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet">
<script>
	function student_send(){
		if(student.syear.value==""){
			alert("학년이 비어있습니다.");
			student.syear.focus();
			return;
		}
		
		
		alert(" 정보를 수정합니다.");
		student.submit();
	}
	
</script>
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
				<h2 class="title">학생 정보 수정</h2>
				<form name="student" method="post" action="student_modify.do">
					<table>
						<tr>
							<td>학년</th>
							<td><input type="text" name="syear" size="2" value="${dto.syear}" readonly> 예) 1</td>
						</tr>
						<tr>
							<td>반</th>
							<td><input type="text" name="sclass" size="2" value="${dto.sclass}" readonly> 예) 01</td>
						</tr>
						<tr>
							<td>번호</th>
							<td><input type="text" name="sno" size="2" value="${dto.sno}" readonly> 예) 01</td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type="text" name="sname" value="${dto.sname}" readonly></td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td>
								<input type="text" name="birth" value="${dto.birth}">
							</td>
						</tr>
						<tr>
							<td>성별</td>
							<td>
								<input type="radio" name="gender" value="M" <c:if test="${dto.gender=='M'}">checked</c:if>>남자
								<input type="radio" name="gender" value="F" <c:if test="${dto.gender=='F'}">checked</c:if>>여자
							</td>
						</tr>
						<tr>
							<td>전화</td>
							<td>
								<input type="text" name="tel1" size="3" value="${dto.tel1}">-
								<input type="text" name="tel2" size="4" value="${dto.tel2}">-
								<input type="text" name="tel3" size="4" value="${dto.tel3}">
							</td>
						</tr>			
						<tr>
							<td colspan="2" class="btn_group">
								<input type="button" value="수정하기" onClick="student_send()">
								<input type="button" value="취소하기"  onClick="history.back()">
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