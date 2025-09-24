<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
	String name[]={"김학생","이학생","박학생","강학생","홍학생","유학생",
"장학생","박학생","호학생","이학생"};
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	<table border=1 width=500>
		<tr>
			<td>번호</td><td>이름</td>
		</tr>
	<%
		for(int i=0; i<10; i++){
	%>	
		<tr>
			<td><%= i+1 %> </td><td><%= name[i] %></td>
		</tr>
	<%
		}
	%>	
	</table>
</body>
</html>