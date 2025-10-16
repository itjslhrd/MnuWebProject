<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.board.*" %>

<%
	int idx = Integer.parseInt(request.getParameter("idx"));

	BoardDAO dao = BoardDAO.getInstance();
	//조회수 증가 메소드 호출
	dao.boardReadCnt(idx);
	
	//idx에 해당하는 글 검색
	BoardDTO01 dto = dao.boardSearch(idx);
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
<script>
</script>
</head>
<body>
	<h1>게시판 글 보기</h1>
	<table>
		<tr>
			<td colspan="2">글 상세보기</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=dto.getName() %>  (조회수:<%=dto.getReadcnt() %>번 /작성일자 : <%=dto.getRegdate() %>)</td>
		</tr>
		<tr>
			<td>글제목</td>
			<td><%= dto.getSubject() %></td>
		</tr>
		<tr>
			<td>글내용</td>
			<td><%=dto.getContents().replace("\n", "<br>") %></td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="board_modify.jsp?idx<%=dto.getIdx()%>">[수정]</a>
				<a href="">[삭제]</a>
				<a href="board_list.jsp">[목록]</a>
			</td>
		</tr>
		
	</table>
</body>
</html>