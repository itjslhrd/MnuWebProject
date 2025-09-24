<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//클라이언트로부터 넘어온 데이터 받기 : request.getParameter("변수명")
	String userid = request.getParameter("userid");
	String passwd = request.getParameter("passwd");

	String id="user01";
	String pw="4321";
	
	if(userid.equals(id)){
		if(passwd.equals(pw)){
%>
		<script>
			alert("로그인 성공");
			location.href="index.html";
		</script>		
<%
		}else{
%>
		<script>
			alert("비밀번호가 맞지않음");
			history.back();
		</script>
<%			
		}
	}else{
%>    
	<script>
		alert("등록된 아이디가 없음");
		history.back();
	</script>

<%
	}
%>
