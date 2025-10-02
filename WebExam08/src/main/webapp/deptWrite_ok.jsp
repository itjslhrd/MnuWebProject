<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>    
    
<%
	request.setCharacterEncoding("utf-8");
	
	int dno = Integer.parseInt(request.getParameter("dno"));
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	DeptDTO dto = new DeptDTO();
	dto.setDno(dno);
	dto.setDname(dname);
	dto.setLoc(loc);

	out.print("dno : " + dno + "<br>");
	out.print("dname : " + dname + "<br>");
	out.print("loc: " + dto.getLoc() + "<br>");
	
	DeptDAO dao = new DeptDAO();
	int row = dao.deptWrite(dto);
	
	//dto.setDno(Integer.parseInt(request.getParameter("dno")));
	
/*
	out.print("dno : " + dno + "<br>");
	out.print("dname : " + dname + "<br>");
	out.print("loc: " + loc + "<br>");
*/
	if(row==1){
%>    
	<script>
		//alert("등록 성공");
		//location.href="index.jsp";
	</script>

<%
	}else{
%>
	<script>
		//alert("등록실패");
		//history.back();
	</script>

<%
	}
%>
