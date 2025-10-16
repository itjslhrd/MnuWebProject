<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.board.*" %>

<%
	//DB 연결
	BoardDAO dao = BoardDAO.getInstance();
	int count = dao.boardCount();//총 게시글 수
	
	List<BoardDTO01> list = dao.boardList();
	
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
        .text_center {text-align:center;}	
		.text_right {text-align:right;}	
	</style>

</head>
<body>
	<h1>게시판 목록</h1>
	<table>
		<tr>
			<td colspan="5" class="text_center">자유게시판(총 글수 : <%= count %>)</td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일자</td>
			<td>조회수</td>
		</tr>
<%
if(list.size() != 0){
	for(BoardDTO01 dto : list){	
%>		
		<tr>
			<td><%= dto.getIdx() %></td>
			<td><%= dto.getSubject() %></td>
			<td><%= dto.getName() %></td>
			<td><%= dto.getRegdate() %></td>
			<td><%= dto.getReadcnt() %></td>
		</tr>
<%
	}//for()끝
}else{
%>		
		<tr>
			<td colspan="5">등록된 글이 없습니다</td>
		</tr>
<%
}
%>
		<tr>
			<td colspan="5" style="text-align:right"><a href="board_write.jsp">글쓰기</a></td>
		</tr>
		
	</table>
</body>
</html>