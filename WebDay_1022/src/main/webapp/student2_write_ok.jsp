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
				<td colspan="2" class="title">학생 정보 등록</td>
			</tr>
			<tr>
				<td>학번</th>
				<td></td>
			</tr>
			<tr>
				<td>이름</td>
				<td></td>
			</tr>
			<tr>
				<td>전화</td>
				<td></td>
			</tr>
			<tr>
				<td>성별</td>
				<td></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td></td>
			</tr>			
			<tr>
				<td>등록일자</td>
				<td></td>
			</tr>			
			<tr>
				<td colspan="2" class="btn">
					<input type="submit" value="등록하기" onclick="student_send()">
					<input type="button" value="다시쓰기" onclick="student_reset()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>