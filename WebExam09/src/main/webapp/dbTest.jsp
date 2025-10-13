<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, model.*" %>

<%
	StudentDAO dao = new StudentDAO();

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