<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.*"%>

<%
	StudentDAO dao = new StudentDAO();

	List<StudentDTO> sList = dao.getStudent();
	//out.print("학생수 : " + sList.size());
	
	//dao.studentInput();
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table { width:600px; border:1px solid #222;	margin:0 auto}
	td { border:1px solid #222; padding : 5px;}
</style>
</head>
<body>
	<table>
		<tr>
			<td>학년-반-번호</td>
			<td>이름</td>
			<td>생년월일</td>
			<td>성별</td>
			<td>전화</td>			
		</tr>
<%
	for(StudentDTO dto : sList){
		String gender="여자";
		if(dto.getGender().equals("M")){
			gender="남자";
		}
		String birth=dto.getBirth().substring(0,4)+"년"+
				dto.getBirth().substring(4,6)+"월"+
				dto.getBirth().substring(6)+"일";
%>		
		<tr>
			<td><%= dto.getSyear() %>-<%= dto.getSclass() %>-<%= dto.getSno() %></td>
			<td><%= dto.getSname() %></td>
			<td><%= birth %></td>
			<td><%= gender %></td>
			<td><%= dto.getTel1() %>-<%= dto.getTel2() %>-<%= dto.getTel3() %></td>			
		</tr>
<%
	}
%>		
		
	</table>
</body>
</html>