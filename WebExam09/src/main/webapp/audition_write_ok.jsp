<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>

<%
	request.setCharacterEncoding("utf-8");
	
	AuditionDAO dao = new AuditionDAO();
	AuditionDTO dto = new AuditionDTO();
	
	dto.setArtist_id(request.getParameter("artist_id"));
	dto.setArtist_name(request.getParameter("artist_name"));
	dto.setArtist_gender(request.getParameter("artist_gender"));
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	
	dto.setArtist_birth(year+month+day);
	dto.setTalent(request.getParameter("talent"));
	dto.setAgency(request.getParameter("agency"));
	
	int row = dao.auditionWrite(dto);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>