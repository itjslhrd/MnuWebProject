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
		function juminFrm_send(){
			var juminExp = /^([0-9]{6})-([0-9]{7})$/;
			
			if(!juminExp.test(juminFrm.jumin.value)){
				alert("Error");
				juminFrm.jumin.focus();
				return;
			}
			alert(" 회원정보를 저장합니다.");
			juminFrm.submit();//전송하라
		}
		function juminFrm_reset(){
			alert("모든 정보를 지우고 다시 입력합니다");
			juminFrm.reset();
			juminFrm.name.focus();
		}	
	</script>
</head>
<body>
	<form name="juminFrm" method="post" action="user_jumin_check_ok.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">화원정보 등록</td>
			</tr>
			<tr>
				<td>회원이름</td>
				<td><input type="text" name="name" ></td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td>
					<input type="text" name="jumin" size=13> 예)900512-1234567	
				</td>
			</tr>
			<tr>
				<td>연락처</td>
				<td>
					<select name="phone1">
						<option value="010">010</option>
						<option value="02">02</option>
						<option value="031">031</option>
						<option value="032">032</option>
						<option value="042">042</option>
						<option value="052">052</option>
					</select> - 
					<input type="text" name="phone2" size="4"> - 
					<input type="text" name="phone3" size="4">
				</td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<select name="job">
						<option>직업을 선택하세요</option>
						<option value="자영업">자영업</option>
						<option value="공무원">공무원</option>
						<option value="회사원">회사원</option>
						<option value="교.강사">교.강사</option>
						<option value="학생">학생</option>
						<option value="기타">기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btn">
					<input type="button" value="등록" onclick="juminFrm_send()">
					<input type="button" value="다시쓰기" onclick="juminFrm_reset()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>