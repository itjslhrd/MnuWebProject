<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Member" %>

<%
request.setCharacterEncoding("utf-8");
	Member mem = new Member();
	
	mem.setCustno(Integer.parseInt(request.getParameter("custno")));
	mem.setCustname(request.getParameter("custname"));
	
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	mem.setPhone(phone1 + "-" + phone2 + "-" + phone3);
	
	mem.setGender(request.getParameter("gender"));

	mem.setGrade(request.getParameter("grade"));
	
	mem.setCity(request.getParameter("city"));
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
			<td colspan="7" class="title">회원등록확인</td>
		</tr>
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>연락처</td>
			<td>성별</td>
			<td>가입일자</td>
			<td>고객등급</td>
			<td>도시코드</td>
		</tr>
		<tr>
			<td><%= mem.getCustno() %></td>
			<td><%= mem.getCustname() %></td>
			<td><%= mem.getPhone() %></td>
			<td><%= mem.getGender() %></td>
			<td><%= mem.getJoindate() %></td>
			<td><%= mem.getGrade() %></td>
			<td><%= mem.getCity() %></td>
		</tr>
		<tr>
			<td colspan="7" class="title"><a href="index.jsp">[홈으로]</a></td>
		</tr>
	</table>

</body>
</html>