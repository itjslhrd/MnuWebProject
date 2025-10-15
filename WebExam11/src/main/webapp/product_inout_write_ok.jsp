<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>    
<%
	request.setCharacterEncoding("utf-8");
	ProductDAO dao = ProductDAO.getInstance();
	InoutDTO dto = new InoutDTO();
	
	dto.setT_no(request.getParameter("t_no"));
	dto.setP_code(request.getParameter("p_code"));
	dto.setT_type(request.getParameter("t_type"));
	dto.setT_cnt(Integer.parseInt(request.getParameter("t_cnt")));
	dto.setT_date(request.getParameter("t_date"));
	dto.setC_code(request.getParameter("c_code"));
	
	int row = dao.productInout(dto);
	if(row==1){
%>    
	<script>
		alert("등록되었습니다");
		location.href="index.jsp";
	</script>
<%
	}else{
%>	
	<script>
		alert("등록실패");
		history.back();	
	</script>
<%
	}
%>
