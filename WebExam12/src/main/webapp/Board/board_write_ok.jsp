<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.board.*" %>

<%
	request.setCharacterEncoding("utf-8");
	
	BoardDAO dao = BoardDAO.getInstance();
	BoardDTO01 dto = new BoardDTO01();
	
	dto.setName(request.getParameter("name"));
	dto.setSubject(request.getParameter("subject"));
	dto.setContents(request.getParameter("contents"));
	dto.setPass(request.getParameter("pass"));
	
	int row = dao.boardWrite(dto);
	if(row==1){
%>
	<script>
		alert("등록되었습니다");
		location.href="board_list.jsp";
	</script>
<%
	}else{
%>	
	<script>
		alert("등록실패");
		history.back();//되돌아가기
	</script>
<%
	}
%>	