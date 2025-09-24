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
	<form name="student" method="post" action="">
		<table>
			<tr>
				<td colspan="2" class="title">학생 정보출력 2</td>
			</tr>
			<tr>
				<td>학년</th>
				<td><input type="text" name="syear" size="5" value="<%= syear %>"></td>
			</tr>
			<tr>
				<td>반</td>
				<td><input type="text" name="sclass" size="5" value="<%= sclass %>"></td>
			</tr>
			<tr>
				<td>번호</td>
				<td><input type="text" name="sno" size="5" value="<%= sno %>"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="sname" value="<%= sname %>"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="sbirth" value="<%= sbirth %>"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="sgender" value="m" <% if(sgender.equals("M")){ %> checked <% } %>>남성
					<input type="radio" name="sgender" value="w" <% if(sgender.equals("W")){ %> checked <% } %>>여성
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="stel"  value="<%= stel %>">-
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btn">
					<input type="button" value="학생등록" onclick="stu_send()">
					<input type="button" value="다시쓰기" onclick="stu_reset()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>