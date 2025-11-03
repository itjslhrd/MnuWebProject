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