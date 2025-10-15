<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>

<%
	ProductDAO dao = ProductDAO.getInstance();
	List<ProductDTO> list = dao.productList();
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
	<table>
		<tr>
			<td class="title" colspan="5">제품조회</td>
		</tr>
		<tr>
			<td class="text_center">제품코드</td>
			<td class="text_center">제품명</td>
			<td class="text_center">사이즈</td>
			<td class="text_right">매입단가</td>
			<td class="text_right">매출단가</td>
		</tr>
<%
	if(list.size() != 0){
		for(ProductDTO dto : list){		
%>		
		<tr>
			<td class="text_center"><a href="product_modify.jsp?p_code=<%= dto.getP_code() %>"><%= dto.getP_code() %></a></td>
			<td class="text_center"><a href="product_modify.jsp?p_code=<%= dto.getP_code() %>"><%= dto.getP_name() %></a></td>
			<td class="text_center"><%= dto.getP_size() %>mm</td>
			<td class="text_right"><%= String.format("￦%,d",dto.getP_incost()) %></td>
			<td class="text_right"><%= String.format("￦%,d",dto.getP_outcost()) %></td>
		</tr>
<%
		}
	}else{
%>		
		<tr>
			<td colspan="5">등록된 자료가 없습니다</td>
		</tr>
<%
	}
%>		
	</table>
</body>
</html>