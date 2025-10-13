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
	<script type="text/javascript">
		function stu_send(){
			if(student.syear.value ==""){
				alert("학년정보가 입력되지 않았습니다!");
				student.syear.focus();
				return;
			}
			if(!student.sclass.value){
				alert("반정보가 입력되지 않았습니다!");
				student.sclass.focus();
				return;
			}
			
			
			alert("학생정보를 저장합니다.");
			student.submit();//전송하라
			
		}
		
		function stu_reset(){
			alert("모든 정보를 지우고 다시 입력합니다");
			student.reset();
			student.syear.focus();
		}
	</script>
</head>
<body>
	<form name="student" method="post" action="student_write_ok.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">학생등록</td>
			</tr>
			<tr>
				<td>학년</th>
				<td><input type="text" name="syear" size="5"></td>
			</tr>
			<tr>
				<td>반</td>
				<td><input type="text" name="sclass" size="5"></td>
			</tr>
			<tr>
				<td>번호</td>
				<td><input type="text" name="sno" size="5"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="sname"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="M">남성
					<input type="radio" name="gender" value="F">여성
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel1" size="3">-
					<input type="text" name="tel2" size="3">-
					<input type="text" name="tel3" size="3">
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