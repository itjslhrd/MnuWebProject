<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.*, java.sql.*" %>

<%
	DeptDAO dao = new DeptDAO();
	
	Connection conn = dao.getConn();
	
	out.print("Conn : " + conn);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>