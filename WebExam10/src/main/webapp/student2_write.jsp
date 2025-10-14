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
	<script>
		function student_send(){
			
			
			alert("학생정보를 저장합니다.");
			student.submit();//전송하라
		}
		function student_reset(){
			alert("모든 정보를 지우고 다시 입력합니다");
			student.reset();
			student.hakbun.focus();
		}	
	</script>
</head>
<body>
	<form name="student" method="post" action="student_write_ok.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">학생 정보 등록</td>
			</tr>
			<tr>
				<td>학번</th>
				<td><input type="text" name="hakbun"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" ></td>
			</tr>
			<tr>
				<td>전화</td>
				<td>
					<input type="text" name="phone1" size=3>-
					<input type="text" name="phone2" size=4>-
					<input type="text" name="phone3" size=4>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="M">남성
					<input type="radio" name="gender" value="F">여성
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth"></td>
			</tr>			
			<tr>
				<td>등록일자</td>
				<td><input type="text" name="regdate"></td>
			</tr>			
			<tr>
				<td colspan="2" class="btn">
					<input type="button" value="등록하기" onclick="student_send()">
					<input type="button" value="다시쓰기" onclick="student_reset()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>