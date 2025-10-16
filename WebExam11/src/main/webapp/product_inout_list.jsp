<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>

<%
	ProductDAO dao = ProductDAO.getInstance();
	List<InoutDTO> list = dao.productInoutList();
	
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
			<td class="title" colspan="5">입출고 조회</td>
		</tr>
		<tr>
			<td class="text_center">입출고번호</td>
			<td class="text_center">제품코드</td>
			<td class="text_center">입출고구분</td>
			<td class="text_center">수량</td>
			<td class="text_center">거래일자</td>
			<td class="text_center">거래처코드</td>
		</tr>
<%
	if(list.size() != 0){
		for(InoutDTO dto : list){		
%>		
		<tr>
			<td class="text_center"><a href="product_inout_modify.jsp?t_no=<%= dto.getT_no() %>"><%= dto.getT_no() %></a></td>
			<td class="text_center"><a href="product_inout_modify.jsp?t_no=<%= dto.getT_no() %>"><%= dto.getP_code() %></a></td>
			<td class="text_center"><%= dto.getT_type() %></td>
			<td class="text_center"><%= dto.getT_cnt() %></td>
			<td class="text_center"><%= dto.getT_date() %></td>
			<td class="text_center"><%= dto.getC_code() %></td>
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