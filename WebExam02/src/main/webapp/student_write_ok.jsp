<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	
	String syear = request.getParameter("syear");
	String sclass = request.getParameter("sclass");
	int sno = Integer.parseInt(request.getParameter("sno"));
	String sname = request.getParameter("sname");
	String sbirth = request.getParameter("sbirth").toUpperCase();
	String sgender = request.getParameter("sgender");
	String stel = request.getParameter("stel1") + "-" +  
			request.getParameter("stel2") + "-" +
			request.getParameter("stel3");
	//19900207"
	String ymd = sbirth.substring(0,4)+"년" + sbirth.substring(4,6)+"월"+sbirth.substring(6)+"일";
	
	String gender = "여자";
	if(sgender.equals("M")){
		gender = "남자";
	}
/*
	out.print("학년 : " + syear + "<br>");
	out.print("반 : " + sclass + "<br>");
	out.print("번호 : " + sno + "<br>");
	out.print("이름 : " + sname + "<br>");
	out.print("생년월일 : " + sbirth + "<br>");
	out.print("성별 : " + sgender + "<br>");
	out.print("전화 : " + stel + "<br>");
*/
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
	<form name="student" method="post" action="student_write_ok.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">학생정보출력</td>
			</tr>
			<tr>
				<td>학년</th>
				<td><%= syear %> </td>
			</tr>
			<tr>
				<td>반</td>
				<td><%= sclass %> </td>
			</tr>
			<tr>
				<td>번호</td>
				<td> <%= sno %></td>
			</tr>
			<tr>
				<td>이름</td>
				<td> <%= sname %></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td> <%= ymd %></td>
			</tr>
			<tr>
				<td>성별</td>
				<td> <%= gender %></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td> <%= stel %></td>
			</tr>
			<tr>
				<td colspan="2" class="btn">
					<a href="index.jsp">[확인]</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>