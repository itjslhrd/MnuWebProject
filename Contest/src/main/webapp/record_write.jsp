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

	.content table {width:550px; border:1px solid black;
                border-collapse: collapse; margin: 0 auto;}
	.content table th, td{border:1px solid #bbb;padding: 0 0 0 5px;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}
</style>
</head>
<body>
	<div class="header">
		<header>
			<h1 class="logo">오디션 관리 프로그램  Ver 1.0</h1>
			<div class="nav">
				<nav>
					<ul>
						<li><a href="entry_write.jsp">지원자 등록</a></li>
						<li><a href="record_write.jsp">경연점수 등록</a></li>
						<li><a href="entry_list.jsp">지원자 목록 조회</a></li>
						<li><a href="record_search.jsp">경연결과 조회</a></li>
						<li><a href="entryRank_list.jsp">최종 등수 조회</a></li>
						<li><a href="index.html">홈으로</a></li>
					</ul>
				</nav>			
			</div>
		</header>
	</div>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">경연 점수 등록</h2>
				<form name="" method="" action="">
					<table>
						<tr>
							<td>참가번호</th>
							<td><input type="text" name=""></td>
						</tr>
						<tr>
							<td>심사위원</th>
							<td>심사점수(1~100)</td>
						</tr>
						<tr>
							<td>김심사</td>
							<td><input type="text" name="" ></td>
						</tr>
						<tr>
							<td>이심사</td>
							<td><input type="text" name="" ></td>
						</tr>
						<tr>
							<td>박심사</td>
							<td><input type="text" name="" ></td>
						</tr>
						<tr>
							<td>황심사</td>
							<td><input type="text" name="" ></td>
						</tr>
						<tr>
							<td>조심사</td>
							<td><input type="text" name="" ></td>
						</tr>
						<tr>
							<td colspan="2" class="btn_group">
								<input type="button" value="등록" >
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