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
		function member_send(){
			member.submit();//전송하라
		}
		function member_reset(){
			alert("모든 정보를 지우고 다시 입력합니다");
			member.reset();
			member.name.focus();
		}	
	</script>

</head>
<body>
	<form name="member" method="post" action="member_write_ok.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">회원등록</td>
			</tr>
			<tr>
				<td>회원번호</td>
				<td><input type="text" name="custno" ></td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td>
					<input type="text" name="custname">	
				</td>
			</tr>
			<tr>
				<td>회원전화</td>
				<td>
					<input type="text" name="phone1" size="3">-
					<input type="text" name="phone2" size="4">-
					<input type="text" name="phone3" size="5">	
				</td>
			</tr>
			<tr>
				<td>회원성별</td>
				<td>
					<input type="radio" name="gender" value="M"> 남자
					<input type="radio" name="gender" value="F"> 여자
				</td>
			</tr>			
			<tr>
				<td>고객등급</td>
				<td>
					<select name="grade">
						<option>고객등급</option>
						<option value="A">VIP</option>
						<option value="B">일반</option>
						<option value="C">직원</option>
					</select> 
				</td>
			</tr>
			<tr>
				<td>도시코드</td>
				<td>
					<input type="text" name="city">	
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btn">
					<input type="button" value="등록하기" onclick="member_send()">
					<input type="button" value="다시쓰기" onclick="member_reset()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>