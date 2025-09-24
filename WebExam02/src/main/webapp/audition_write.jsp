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
		function audition_send(){
			
			
			alert("오디션정보를 저장합니다.");
			audition.submit();//전송하라
		}
		function audition_reset(){
			alert("모든 정보를 지우고 다시 입력합니다");
			audition.reset();
			audition.no.focus();
		}	
	</script>
</head>
<body>
	<form name="audition" method="post" action="audition_write_ok.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">오디션 등록</td>
			</tr>
			<tr>
				<td>참가번호</th>
				<td><input type="text" name="no"> * 참가번호는(A000)4자리 입니다</td>
			</tr>
			<tr>
				<td>참가자명</td>
				<td><input type="text" name="name" ></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<input type="text" name="year" size=4>년
					<input type="text" name="month" size=4>월
					<input type="text" name="day" size=4>일
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
				<td>특기</td>
				<td>
					<select name="talent">
						<option>특기선택</option>
						<option value="1">댄스</option>
						<option value="2">랩</option>
						<option value="3">노래</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>소속사</td>
				<td><input type="text" name="agency"></td>
			</tr>			
			<tr>
				<td colspan="2" class="btn">
					<input type="button" value="오디션록" onclick="audition_send()">
					<input type="button" value="다시쓰기" onclick="audition_reset()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>