<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="login" method="post" action="login.do">
		<table border="1" width="300">
			<tr>
				<td colspan="2">로그인 폼</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="취소">
				</td>
			</tr>			
		</table>
	</form>
</body>
</html>