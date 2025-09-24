<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String job = request.getParameter("job");
	String sports[] = request.getParameterValues("sports");
	
	String str=sports[0];
	for(int i=1; i<sports.length; i++){
		str = str + "," + sports[i];
	}
	
	out.print("이름 : " + name + "<br>");
	out.print("성별 : " + gender + "<br>");
	out.print("직업 : " + job + "<br>");
	out.print("운동 : " + str + "<br>");
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        table{width:550px; border:1px solid black;
                border-collapse: collapse; margin: 0 auto;}
        td {border:1px solid black;
            padding: 5px;}
        .title{font-size:20px; text-align: center;}    
        .btn{text-align: center;}
    </style>
</head>
<body>
	<form name="frm" method="post" action="write_pro.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">수정하기</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%= name %>" readonly></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="M" <% if(gender.equals("M")){ %> checked <% } %>>남자
					<input type="radio" name="gender" value="F" <% if(gender.equals("F")){ %> checked <% } %>>여자
				</td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<select name="job">
						<option>직업을 선택하세요</option>
						<option value="공무원" <% if(job.equals("공무원")){ %> selected <% } %>>공무원</option>
						<option value="회사원" <% if(job.equals("회사원")){ %> selected <% } %>>회사원</option>
						<option value="교직원" <% if(job.equals("교직원")){ %> selected <% } %>>교직원</option>
						<option value="군인" <% if(job.equals("군인")){ %> selected <% } %>>군인</option>
						<option value="학생" <% if(job.equals("학생")){ %> selected <% } %>>학생</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>종아하는 운동</td>
				<td>
					<input type="checkbox" name="sports" value="축구" <% if(str.contains("축구")){ %> checked <% } %>>축구
					<input type="checkbox" name="sports" value="야구" <% if(str.contains("야구")){ %> checked <% } %>>야구
					<input type="checkbox" name="sports" value="배구" <% if(str.contains("배구")){ %> checked <% } %>>배구
					<input type="checkbox" name="sports" value="농구" <% if(str.contains("농구")){ %> checked <% } %>>농구
					<input type="checkbox" name="sports" value="수영" <% if(str.contains("수영")){ %> checked <% } %>>수영
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btn">
					<input type="button" value="등록" onclick="frm_send()">
					<input type="button" value="돌아가기" onclick="history.back()">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>