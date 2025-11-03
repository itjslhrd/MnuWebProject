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
		function frm_send(){
			if(frm.artist_id.value==""){
				alert("참가번호가 비어있습니다.");
				frm.artist_id.focus();
				return;
			}
			if(frm.artist_name.value==""){
				alert("참가자명이 비어있습니다.");
				frm.artist_name.focus();
				return;
			}
			if(frm.birth1.value=="" || frm.birth2.value=="" || frm.birth3.value==""){
				alert("생년월일이 비어있습니다.");
				frm.artist_birth1.focus();
				return;
			}
			if(!frm.artist_gender[0].checked && !frm.artist_gender[1].checked ){
				alert("성별이 선택되지 않았습니다.");
				return;
			}
			if(frm.talent.selectedIndex==0){
				alert("특기가 선택되지 않았습니다.");
				frm.talent.focus();
				return;
			}
			if(frm.agency.value==""){
				alert("소속사가 비어있습니다.");
				frm.agency.focus();
				return;
			}
			
			frm.submit();
		}
	
	</script>
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
				<form name="frm" method="post" action="artist_write.do">
					<table>
						<tr>
							<td>참가번호</th>
							<td><input type="text" name="artist_id"> * 참가번호는(A000)4자리 입니다</td>
						</tr>
						<tr>
							<td>참가자명</td>
							<td><input type="text" name="artist_name" ></td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td>
								<input type="text" name="birth1" size=4>년
								<input type="text" name="birth2" size=4>월
								<input type="text" name="birth3" size=4>일
							</td>
						</tr>
						<tr>
							<td>성별</td>
							<td>
								<input type="radio" name="artist_gender" value="M" >남성
								<input type="radio" name="artist_gender" value="F" >여성
							</td>
						</tr>
						<tr>
							<td>특기</td>
							<td>
								<select name="talent">
									<option>특기선택</option>
									<option value="1">댄스</option>
									<option value="2">랩</option>
									<option value="3">노래</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>소속사</td>
							<td><input type="text" name="agency"></td>
						</tr>			
						<tr>
							<td colspan="2" class="btn_group">
								<input type="button" value="오디션록" onClick="frm_send()">
								<input type="button" value="다시쓰기" onClick="history.back()">
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