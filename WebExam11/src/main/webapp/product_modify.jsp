<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String p_code = request.getParameter("p_code");

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
	<script>
		function product_send(){
			
			
			alert("제품정보를 수정합니다.");
			product.submit();//전송하라
		}
		function product_reset(){
			alert("모든 정보를 지우고 다시 입력합니다");
			product.reset();
			product.t_no.focus();
		}	
	</script>
</head>
<body>
	<form name="product" method="post" action="product_modify_ok.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">제품 정보 수정</td>
			</tr>
			<tr>
				<td>제품코드</th>
				<td><input type="text" name="p_code" value="<%= p_code %>"></td>
			</tr>
			<tr>
				<td>제품명</th>
				<td><input type="text" name="p_name"></td>
			</tr>
			<tr>
				<td>사이즈</td>
				<td>
					<input type="text" name="t_size">
				</td>
			</tr>
			<tr>
				<td>매입단가</td>
				<td>
					<input type="text" name="p_incost">
				</td>
			</tr>
			<tr>
				<td>매출단가</td>
				<td>
					<input type="text" name="p_outcost">
				</td>
			</tr>			
			<tr>
				<td colspan="2" class="btn">
					<input type="button" value="제품정보수정" onclick="product_send()">
					<input type="button" value="다시쓰기" onclick="product_reset()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>