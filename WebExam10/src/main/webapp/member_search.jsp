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
			if(!member.custno.value){
				alert("회원번호를 입력하세요");
				member.custno.focus();
				return;
			}
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
	<form name="member" method="post" action="member_search_ok.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">회원 정보 검색</td>
			</tr>
			<tr>
				<td>회원번호</th>
				<td><input type="text" name="custno" ></td>
			</tr>
			<tr>
				<td colspan="2" class="btn">
					<input type="button" value="검색하기" onclick="member_send()">
					<input type="button" value="다시쓰기" onclick="member_reset()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>