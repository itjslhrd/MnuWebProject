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
			if(!student.name.value){
				alert("이름을 입력하세요");
				student.name.focus();
				return;
			}
			
			alert("학생정보를 검색합니다.");
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
	<form name="student" method="post" action="student_search_ok.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">학생 정보 검색</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" ></td>
			</tr>
			<tr>
				<td colspan="2" class="btn">
					<input type="button" value="검색하기" onclick="student_send()">
					<input type="button" value="다시쓰기" onclick="student_reset()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>