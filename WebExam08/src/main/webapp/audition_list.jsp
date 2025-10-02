<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>

<%
	ArtistDAO dao = new ArtistDAO();
	List<ArtistDTO> list = dao.artistList();

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
			<td colspan="6" class="title">참가자 목록 조회</td>
		</tr>
		<tr>
			<td>참가번호</th>
			<td>참가자명</td>
			<td>생년월일</td>
			<td>성별</td>
			<td>특기</td>
			<td>소속사</td>
		</tr>
<%
	for(ArtistDTO dto : list){
%>		
		<tr>
			<td><%= dto.getArtist_id() %></th>
			<td><%= dto.getArtist_name() %></td>
			<td><%= dto.getArtist_birth() %></td>
			<td><%= dto.getArtist_gender() %></td>
			<td><%= dto.getTalent() %></td>
			<td><%= dto.getAgency() %></td>
		</tr>
<%
	}
%>		
	</table>

</body>
</html>