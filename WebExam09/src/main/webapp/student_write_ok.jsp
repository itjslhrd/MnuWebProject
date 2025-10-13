<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, model.*" %>

<%
	request.setCharacterEncoding("utf-8");

	StudentDTO dto = new StudentDTO();
	
	//String syear = request.getParameter("syear");
	//dto.setSyear(syear);
	dto.setSyear(request.getParameter("syear"));
	dto.setSclass(request.getParameter("sclass"));
	dto.setSno(request.getParameter("sno"));
	dto.setSname(request.getParameter("sname"));
	dto.setBirth(request.getParameter("birth"));
	dto.setGender(request.getParameter("gender"));
	dto.setTel1(request.getParameter("tel1"));
	dto.setTel2(request.getParameter("tel2"));
	dto.setTel3(request.getParameter("tel3"));
	
	//테스트
	//out.print("학년 : " + dto.getSyear() + "<br>");
	
/*
	String syear = request.getParameter("syear");
	String sclass = request.getParameter("sclass");
	String sno = request.getParameter("sno");
	String sname = request.getParameter("sname");
	String birth = request.getParameter("birth");
	String gender = request.getParameter("gender");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");

	out.print("학년 : " + syear + "<br>");
	out.print("반 : " + sclass + "<br>");
	out.print("번호 : " + sno + "<br>");
	out.print("이름 : " + sname + "<br>");
	out.print("생년월일 : " + birth + "<br>");
	out.print("성별 : " + gender + "<br>");
	out.print("전화 : " + tel1 + tel2 + tel3 + "<br>");
*/	

	StudentDAO dao = new StudentDAO();
	
	int row = dao.studentWrite(dto);
	
	//out.print("row : " + row);
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
