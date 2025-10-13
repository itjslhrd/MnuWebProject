<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>    

<%
	//객체 생성
	StudentDAO dao = new StudentDAO();

	//메소드 호출
	List<StudentDTO> list = dao.studentList();
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
			<td colspan="5" class="title">학생 전체 목록</td>
		</tr>
		<tr>
			<td>학번</td>
			<td>이름</td>
			<td>생년월일</td>
			<td>성별</td>
			<td>전화</td>
		</tr>
<%
	for(StudentDTO dto : list){
		String birth = dto.getBirth().substring(0,4)+"년" +
				dto.getBirth().substring(4,6)+"월" +
				dto.getBirth().substring(6)+"일";
		String gender = "여자";
		if(dto.getGender().equalsIgnoreCase("m")){
			gender = "남자";
		}
%>		
		<tr>
			<td><%= dto.getSyear() %> - <%= dto.getSclass() %> - <%= dto.getSno() %></td>
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