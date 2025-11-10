<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			out.print("Driver Loading OK<br>");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.207.103:1521/xe","C##HR", "1234");
			out.print("Connection : " + conn);
			
		}catch(Exception e){
			e.printStackTrace();
		}
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