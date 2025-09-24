<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>

<%
	StudentDTO dto[] = new StudentDTO[5];
	dto[0] = new StudentDTO("김학생","M","공무원","축구,배구");
	dto[1] = new StudentDTO("이학생","M","학생","배구");
	dto[2] = new StudentDTO("박학생","F","회사원","축구,야구,배구");
	dto[3] = new StudentDTO("강학생","F","군인","축구");
	dto[4] = new StudentDTO("오학생","M","교직원","축구,배구,야구,농구");

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        table{width:550px; border:1px solid black;
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
			<td colspan="4">회원전체List</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>성별</td>
			<td>직업</td>
			<td>운동</td>
		</tr>
<%
	for(int i=0; i<dto.length; i++){
		
		String gender="여자";
		if(dto[i].getGender().equals("M")){
			gender="남자";
		}
%>		
		<tr>
			<td><%= dto[i].getName() %></td>
			<td><%= gender %></td>
			<td><%= dto[i].getJob() %></td>
			<td><%= dto[i].getSports() %></td>
		</tr>
<%
	}
%>		
	</table>	
	
</body>
</html>