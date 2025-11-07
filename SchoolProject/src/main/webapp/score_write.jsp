<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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