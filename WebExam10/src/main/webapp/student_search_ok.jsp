<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>

<%
	request.setCharacterEncoding("utf-8");

	StudentDAO dao = new StudentDAO();
	String name = request.getParameter("name");
	//메소드 호출
	List<StudentDTO> list = dao.studentNameSearch(name);
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
				<td colspan="6" class="title">회원 정보 검색</td>
			</tr>
			<tr>
				<td>학생번호</td>
				<td>학생이름</td>
				<td>전화번호</td>
				<td>성별</td>
				<td>생년월일</td>
				<td>가입일자</td>		
			</tr>
<%
	if(list.size() != 0) {
		for(StudentDTO dto : list){
%>	
			<tr>
				<td><%= dto.getHakbun() %></td>
				<td><%= dto.getName() %></td>
				<td><%= dto.getPhone1() %>-<%= dto.getPhone2() %>-<%= dto.getPhone3() %></td>
				<td><%= dto.getGender() %></td>
				<td><%= dto.getBirth() %></td>
				<td><%= dto.getRegdate() %></td>		
			</tr>
<%
		}
	}else{
%>						
			<tr>
				<td colspan="6" class="btn">
					등록된 학생이 없습니다.
				</td>
			</tr>
<%
	}
%>
			<tr>
				<td colspan="6" class="btn">
					<a href="javascript:history.back()">[확인]</a>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>