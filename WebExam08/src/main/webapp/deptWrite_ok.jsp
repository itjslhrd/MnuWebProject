<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	
	int dno = Integer.parseInt(request.getParameter("dno"));
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	//테스트
	out.print("dno : " + dno + "<br>");
	out.print("dname : " + dname + "<br>");
	out.print("loc: " + loc + "<br>");

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