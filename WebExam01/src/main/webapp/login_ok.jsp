<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//클라이언트로부터 넘어온 데이터 받기 : request.getParameter("변수명")
	String userid = request.getParameter("userid");
	String passwd = request.getParameter("passwd");

	String id="user01";
	String pw="4321";
	
	boolean sw=false;
	if(userid.equals(id) && passwd.equals(pw)){
		sw=true;
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 로그인 처리 </h1>
<%
	if(sw){
%>	
	<h3>로그인 되었습니다 </h3>
	<h3>아이디 : <%= userid %></h3>
	<h3>비밀번호 : <%= passwd %></h3>
	<h3><a href="index.html">메인으로 이동</a></h3>
<%
	}else{
%>	
	<h3>로그인 실패(아이디 또는 비번오류) </h3>
	<h3><a href="javascript:history.back()">되돌아 가기</a></h3>
		
<%
	}
%>	
</body>
</html>