<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>    
<%
	request.setCharacterEncoding("utf-8");
	ProductDAO dao = ProductDAO.getInstance();
	ProductDTO dto = new ProductDTO();
	
	dto.setP_code(request.getParameter("p_code"));
	dto.setP_name(request.getParameter("p_name"));
	dto.setP_size(Integer.parseInt(request.getParameter("p_size")));
	dto.setP_incost(Integer.parseInt(request.getParameter("p_incost")));
	dto.setP_outcost(Integer.parseInt(request.getParameter("p_outcost")));
	
	int row = dao.productModify(dto);
	if(row==1){
%>    
	<script>
		alert("수정되었습니다");
		location.href="index.jsp";
	</script>
<%
	}else{
%>	
	<script>
		alert("수정실패");
		history.back();	
	</script>
<%
	}
%>
