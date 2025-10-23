<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
				<td colspan="2" class="title">학생등록</td>
			</tr>
			<tr>
				<td>학년</th>
				<td>${syear}</td>
			</tr>
			<tr>
				<td>반</td>
				<td>${sclass}</td>
			</tr>
			<tr>
				<td>번호</td>
				<td>${sno }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${sname }</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>${birth }</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>${gender }</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${tel1}-${tel2}-${tel3}</td>
			</tr>
			<tr>
				<td colspan="2" class="btn">
					
				</td>
			</tr>
		</table>
</body>
</html>