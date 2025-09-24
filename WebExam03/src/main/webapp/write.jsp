<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        table{width:550px; border:1px solid black;
                border-collapse: collapse; margin: 0 auto;}
        td {border:1px solid black;
            padding: 5px;}
        .title{font-size:20px; text-align: center;}    
        .btn{text-align: center;}
    </style>
	<script>
		//유효성 검사 완료
		function frm_send(){
			alert("정보를 등록합니다");
			frm.submit();
		}
	
	</script>
</head>
<body>
	<form name="frm" method="post" action="write_pro.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">등록하기</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="M">남자
					<input type="radio" name="gender" value="F">여자
				</td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<select name="job">
						<option>직업을 선택하세요</option>
						<option value="공무원">공무원</option>
						<option value="회사원">회사원</option>
						<option value="교직원">교직원</option>
						<option value="군인">군인</option>
						<option value="학생">학생</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>종아하는 운동</td>
				<td>
					<input type="checkbox" name="sports" value="축구">축구
					<input type="checkbox" name="sports" value="야구">야구
					<input type="checkbox" name="sports" value="배구">배구
					<input type="checkbox" name="sports" value="농구">농구
					<input type="checkbox" name="sports" value="수영">수영
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btn">
					<input type="button" value="등록" onclick="frm_send()">
					<input type="button" value="돌아가기" onclick="history.back()">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>