<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>

<%
	MemberDAO dao = new MemberDAO();
	int custno = Integer.parseInt(request.getParameter("custno"));
	//메소드 호출
	MemberDTO dto = dao.custnoSearch(custno);
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
</head>
<body>
		<table>
			<tr>
				<td colspan="2" class="title">회원 정보</td>
			</tr>
<%
	if(dto.getCustno() != 0) {
%>	
			<tr>
				<td>회원번호</th>
				<td><%= dto.getCustno() %></td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td><%= dto.getCustname() %></td>
			</tr>
			<tr>
				<td>회원전화</td>
				<td><%= dto.getPhone() %></td>
			</tr>
			<tr>
				<td>회원성별</td>
				<td><%= dto.getGender() %></td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td><%= dto.getJoindate() %></td>
			</tr>			
			<tr>
				<td>고객등급</td>
				<td><%= dto.getGrade() %></td>
			</tr>
			<tr>
				<td>도시코드</td>
				<td><%= dto.getCity() %></td>
			</tr>
<%
	}else{
%>						
			<tr>
				<td colspan="2" class="btn">
					등록된 회원이 없습니다.
				</td>
			</tr>
<%
	}
%>
			<tr>
				<td colspan="2" class="btn">
					<a href="javascript:history.back()">[확인]</a>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>