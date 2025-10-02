<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>
<%
	DeptDAO dao = new DeptDAO();

	List<DeptDTO> list = dao.deptList();

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="400">
		<tr>
			<td colspan="3">부서정보 목록</td>
		</tr>
		<tr>
			<td>부서번호</td>
			<td>부서명</td>
			<td>부서위치</td>
		</tr>
<%
	for(DeptDTO dto : list){
%>	
		<tr>
			<td><%= dto.getDno() %> </td>
			<td><%= dto.getDname() %> </td>
			<td><%= dto.getLoc() %> </td>
		</tr>
<%
	}
%>	
	</table>
</body>
</html>