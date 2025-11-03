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
						<li><a href="artist_write.jsp">오디션 지원자 등록</a></li>
						<li><a href="artist_list.jsp">참가자목록조회</a></li>
						<li><a href="mentoScore_list.jsp">멘토점수조회</a></li>
						<li><a href="artist_search.jsp">참가자조회</a></li>
						<li><a href="artistRank_list.jsp">참가자등수조회</a></li>
						<li><a href="index.html">홈으로</a></li>
					</ul>
				</nav>			
			</div>
		</header>
	</div>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">참가자 목록 조회</h2>
					<table>
						<tr>
							<td>참가번호</th>
							<td>참가자명</td>
							<td>생년월일</td>
							<td>성별</td>
							<td>특기</td>
							<td>소속사</td>
						</tr>
						<tr>
							<td>A001</th>
							<td>김스타</td>
							<td>1997년01월01일</td>
							<td>여성</td>
							<td>댄스</td>
							<td>A엔터테인먼트</td>
						</tr>
						<tr>
							<td>A002</th>
							<td>조스타</td>
							<td>1998년02월01일</td>
							<td>남성</td>
							<td>노래</td>
							<td>B엔터테인먼트</td>
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