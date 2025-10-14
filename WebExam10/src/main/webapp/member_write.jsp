<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%
	MemberDAO dao = new MemberDAO();
	int custno = dao.custnoMax();
	if(custno==0){
		custno = 100001;
	}else{
		custno = custno + 1;
	}
%>    
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
			
			
			alert("회원정보를 저장합니다.");
			member.submit();//전송하라
		}
		function member_reset(){
			alert("모든 정보를 지우고 다시 입력합니다");
			member.reset();
			member.custname.focus();
		}	
	</script>
</head>
<body>
	<form name="member" method="post" action="member_write_ok.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">회원 정보 등록</td>
			</tr>
			<tr>
				<td>회원번호(자동생성)</th>
				<td><input type="text" name="custno" readonly value="<%= custno %>"></td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td><input type="text" name="custname" ></td>
			</tr>
			<tr>
				<td>회원전화</td>
				<td>
					<input type="text" name="tel1" size=3>-
					<input type="text" name="tel2" size=4>-
					<input type="text" name="tel3" size=4>
				</td>
			</tr>
			<tr>
				<td>회원성별</td>
				<td>
					<input type="radio" name="gender" value="M">남성
					<input type="radio" name="gender" value="F">여성
				</td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td><input type="text" name="joindate"></td>
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
				<td><input type="text" name="city"></td>
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