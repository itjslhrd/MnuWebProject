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
			<td>학점</td>
		</tr>
<%
	for(int i=0; i<stu.length; i++){
		String grade="";
		if(stu[i].getAve()>=90){
			grade="A";
		}else if(stu[i].getAve()>=80){
			grade="B";
		}else if(stu[i].getAve()>=70){
			grade="C";
		}else if(stu[i].getAve()>=60){
			grade="D";
		}else{
			grade="F";
		}
%>		
		<tr>
			<td><%= stu[i].getBun() %></td>
			<td><%= stu[i].getName() %></td>
			<td><%= stu[i].getKor() %></td>
			<td><%= stu[i].getEng() %></td>
			<td><%= stu[i].getMat() %></td>
			<td><%= stu[i].getTot() %></td>
			<td><%= stu[i].getAve() %></td>			
			<td><%= grade %></td>
		</tr>
<%
	}
%>		
	</table>
</body>
</html>