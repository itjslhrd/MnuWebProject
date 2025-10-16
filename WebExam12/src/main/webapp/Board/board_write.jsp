<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	function board_send(){
		alert("게시글을 등록합니다");
		board.submit();
	}
</script>
</head>
<body>
	<h1>게시판 글 등록</h1>
	<form name="board" method="post" action="board_write_ok.jsp">
		<table>
			<tr>
				<td colspan="2">글 쓰기</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type="text" name="subject" size="50"></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td>
					<textarea name="contents" cols="50" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td>비번용</td>
				<td><input type="password" name="pass"> * 수정삭제시 필요</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="등록" onclick="board_send()">
					<input type="button" value="취소" onclick="history.back()">
				</td>
			</tr>
			
		</table>
	
	</form>
</body>
</html>