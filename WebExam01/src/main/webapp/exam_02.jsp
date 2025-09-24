<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>    
<%
	Student stu[] = new Student[5];
	Student st1 = new Student(1,"힉학생",90,88,90);
	stu[0] = st1;
	st1 = new Student(2,"강학생",95,80,95);
	stu[1] = st1;
	stu[2] = new Student(3,"최학생",65,60,65);
	stu[3] = new Student(4,"오학생",85,88,95);
	stu[4] = new Student(5,"유학생",75,65,85);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1" width="700">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>국어</td>
			<td>영어</td>
			<td>수학</td>
			<td>총점</td>
			<td>평균</td>
		</tr>
		<tr>
			<td><%= st1.getBun() %></td>
			<td><%= st1.getName() %></td>
			<td><%= st1.getKor() %></td>
			<td><%= st1.getEng() %></td>
			<td><%= st1.getMat() %></td>
			<td><%= st1.getTot() %></td>
			<td><%= st1.getAve() %></td>
		</tr>
		
	</table>
</body>
</html>