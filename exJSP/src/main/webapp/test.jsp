<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<td>값</td><td>합계</td>
		</tr>		
<%
	int s=0;
	for(int i=1; i<=10; i++){
		s += i;
%>
		<tr>
			<td><%= i %></td><td><%= s %></td>
		</tr>

<%
	}
%>
	</table>

</body>
</html>