<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet">
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo {color:#fff; text-align:center; background-color:#0040FF; padding:16px 0;}
	.nav{padding:12px 0; overflow:hidden;background-color:#BCA9F5;}
	.nav ul,li{float:left; padding:0 20px; text-align:center;}
	.content {background-color:#E6E6E6; padding:16px;}
	.title {text-align:center;padding:22px;}
	.content table{width:550px;margin:0 auto;}
	.content table th, td{border:1px solid #bbb;padding: 0 0 0 5px;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}
</style>

</head>
<body>
	<div class="header">
		<header>
			<h1 class="logo">고교 성적 관리 프로그램  Ver 1.0</h1>
			<div class="nav">
				<nav>
					<ul>
						<li><a href="student_write.jsp">학생등록</a></li>
						<li><a href="student_list.jsp">학생조회</a></li>
						<li><a href="score_write.jsp">성적입력</a></li>
						<li><a href="score_list.jsp">성적조회</a></li>
						<li><a href="classCount_list.jsp">반별통계</a></li>
						<li><a href="index.html">홈으로</a></li>
					</ul>
				</nav>			
			</div>
		</header>
	</div>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">학생 정보 조회</h2>
					<table>
						<tr>
							<td>학년-반-번호</th>
							<td>이름</td>
							<td>생년월일</td>
							<td>성별</td>
							<td>전화</td>
						</tr>
						<tr>
							<td>1-01-01</th>
							<td>김학생</td>
							<td>2002년01월01일</td>
							<td>여자</td>
							<td>010-1234-1001</td>
						</tr>
						<tr>
							<td>1-01-02</th>
							<td>이학생</td>
							<td>2002년02월01일</td>
							<td>남자</td>
							<td>010-1234-1002</td>
						</tr>
						<tr>
							<td>1-01-03</th>
							<td>박학생</td>
							<td>2002년03월01일</td>
							<td>여자</td>
							<td>010-1234-1003</td>
						</tr>
						<tr>
							<td>1-02-01</th>
							<td>조학생</td>
							<td>2002년04월01일</td>
							<td>남자</td>
							<td>010-1234-1004</td>
						</tr>
						<tr>
							<td>1-02-02</th>
							<td>유학생</td>
							<td>2002년05월01일</td>
							<td>남자</td>
							<td>010-1234-1005</td>
						</tr>
						<tr>
							<td>1-02-03</th>
							<td>여학생</td>
							<td>2002년06월01일</td>
							<td>남자</td>
							<td>010-1234-1006</td>
						</tr>
						<tr>
							<td>1-03-01</th>
							<td>남학생</td>
							<td>2002년07월01일</td>
							<td>여자</td>
							<td>010-1234-1007</td>
						</tr>
						<tr>
							<td>1-03-02</th>
							<td>황학생</td>
							<td>2002년08월01일</td>
							<td>여자</td>
							<td>010-1234-1008</td>
						</tr>
						<tr>
							<td>1-03-03</th>
							<td>전학생</td>
							<td>2002년09월01일</td>
							<td>여자</td>
							<td>010-1234-1009</td>
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