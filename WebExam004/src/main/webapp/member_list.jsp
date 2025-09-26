<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Member" %>

<%
	Member mem[] = new Member[6];
	
	mem[0] = new Member(100001,"김행목","010-1111-2222","M","20151202","A","01");
	mem[1] = new Member(100002,"이축복","010-1111-3333","M","20151206","B","01");
	mem[2] = new Member(100003,"장믿음","010-1111-4444","F","20151001","B","02");
	mem[3] = new Member(100004,"최사랑","010-1111-5555","F","20151113","A","02");
	mem[4] = new Member(100005,"진평화","010-1111-6666","F","20151225","B","11");
	mem[5] = new Member(100006,"차공단","010-1111-7777","M","20151211","C","11");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
        table {width:650px; border:1px solid black;
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
			<td colspan="7" class="title">회원전체검색</td>
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
<%
	for(Member m : mem){
		String gender="여자";
		if(m.getGender().equals("M")){
			gender="남자";
		}
		String joindate=m.getJoindate().substring(0,4)+"년" + 
				m.getJoindate().substring(4,6)+"월" +
				m.getJoindate().substring(6)+"일";
		String grade="직원";
		if(m.getGrade().equals("A")){
			grade="VIP";
		}else if(m.getGrade().equals("B")){
			grade="일반";
		}
%>		
		<tr>
			<td><%= m.getCustno() %></td>
			<td><%= m.getCustname() %></td>
			<td><%= m.getPhone() %></td>
			<td><%= gender %></td>
			<td><%= joindate %></td>
			<td><%= grade %></td>
			<td><%= m.getCity() %></td>
		</tr>
<%
	}
%>		
		<tr>
			<td colspan="7" class="title"><a href="index.jsp">[홈으로]</a></td>
		</tr>
	</table>

</body>
</html>