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
	</style>
	<script>
		function product_send(){
			
			
			alert("입출고 정보를 저장합니다.");
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
	<form name="product" method="post" action="product_inout_write_ok.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">입출고 등록</td>
			</tr>
			<tr>
				<td>입출고번호</th>
				<td><input type="text" name="t_no"> 예)20200006</td>
			</tr>
			<tr>
				<td>제품코드</th>
				<td><input type="text" name="p_code"></td>
			</tr>
			<tr>
				<td>입출고구분</td>
				<td>
					<input type="radio" name="t_type" value="I">입고
					<input type="radio" name="t_type" value="O">출고
				</td>
			</tr>
			<tr>
				<td>수량</td>
				<td>
					<input type="text" name="t_cnt">
				</td>
			</tr>
			<tr>
				<td>거래일자</td>
				<td>
					<input type="text" name="t_date">
				</td>
			</tr>
			<tr>
				<td>거래처</td>
				<td>
					<select name="c_code">
						<option>거래처명</option>
						<option value="10">서울공장</option>
						<option value="20">울산공장</option>
						<option value="30">부산상사</option>
						<option value="40">광주상사</option>
						<option value="50">대전상사</option>
					</select>
				</td>
			</tr>			
			<tr>
				<td colspan="2" class="btn">
					<input type="button" value="입출고등록" onclick="product_send()">
					<input type="button" value="다시쓰기" onclick="product_reset()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>