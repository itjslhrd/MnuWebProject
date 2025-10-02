<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send(){
		if(dept.dno.value==""){
			alert("부서번호를 입력하세요");
			dept.dno.focus();
			return;
		}
		if(dept.dname.value==""){
			alert("부서명를 입력하세요");
			dept.dname.focus();
			return;
		}
		if(dept.loc.value==""){
			alert("지역명호를 입력하세요");
			dept.loc.focus();
			return;
		}
		
		alert("등록합니다");
		dept.submit();
	}
</script>
</head>
<body>
	<form name="dept" method="post" action="deptWrite_ok.jsp">
		<table border="1" width="300">
			<tr>
				<td colspan=2"> 등록 </td>
			</tr>
			<tr>
				<td>부서번호</td>
				<td><input type="text" name="dno"></td>
			</tr>
			<tr>
				<td>부서명</td>
				<td><input type="text" name="dname"></td>
			</tr>
			<tr>
				<td>지역명</td>
				<td><input type="text" name="loc"></td>
			</tr>
			<tr>
				<td colspan=2">
					<input type="button" value="등록" onclick="send()">
					<input type="button" value="취소" onclick="history.back()">
				</td>
			</tr>			
		</table>
	</form>
</body>
</html>