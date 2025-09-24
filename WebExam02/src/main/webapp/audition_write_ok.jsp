<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("no");
	String name = request.getParameter("name");
	
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	String birth = year+"년"+month +"월"+ day+"일";
	
	String gender = request.getParameter("gender");
	String genderStr="여자";
	if(gender.equals("M")){
		genderStr="남자";
	}
	int tal = Integer.parseInt(request.getParameter("talent"));
	String talent="노래";
	if(tal==1){
		talent="댄스";
	}else if(tal==2){
		talent="랩";
	}
	String agency = request.getParameter("agency");
	
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
	<form name="audition" method="post" action="audition_write_ok.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">오디션 등록</td>
			</tr>
			<tr>
				<td>참가번호</th>
				<td><%= no %> </td>
			<tr>
				<td>참가자명</td>
				<td><%= name %> </td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td> <%= birth %></td>
			</tr>
			<tr>
				<td>성별</td>
				<td> <%= genderStr %></td>
			</tr>
			<tr>
				<td>특기</td>
				<td> <%= talent %></td>
			</tr>
			<tr>
				<td>소속사</td>
				<td><%= agency %> </td>
			</tr>			
			<tr>
				<td colspan="2" class="btn">
					<a href="">등록확인</a>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>