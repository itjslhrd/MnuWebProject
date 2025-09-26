<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");

	String gdate = request.getParameter("gdate");//수강월
	String gno = request.getParameter("gno");//회원번호
	String gclass = request.getParameter("gclass");//강의장소
	String glecture = request.getParameter("code");//강의코드
	int gprice = Integer.parseInt(request.getParameter("gprice"));//수강료

	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
        table {width:550px; border:1px solid black;
                border-collapse: collapse; margin: 0 auto;}
        td {border:1px solid black;
            padding: 5px;}
        .title{font-size:20px; text-align: center;}    
        .btn{text-align: center;}
	</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="5" class="title">골프 수강 신청 정보 출력</td>
		</tr>
		<tr>
			<td>수강월</td>
			<td>회원번호</td>
			<td>강의장소</td>
			<td>강의코드</td>
			<td>수강료</td>
		</tr>
		<tr>
			<td><%= gdate %></td>
			<td><%= gno %></td>
			<td><%= gclass %></td>
			<td><%= glecture %></td>
			<td><%= String.format("%,d", gprice) %></td>
		</tr>
		
		<tr>
			<td colspan="5" class="btn">
				<a href="">확인</a>
				<a href="">돌아가기</a>
			</td>
		</tr>
	</table>
</body>

</html>