<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String jumin = request.getParameter("jumin");//주민번호
	String tel = request.getParameter("phone1")+"-"+
			request.getParameter("phone2")+"-"+
			request.getParameter("phone3");
	String job = request.getParameter("job");
	
	String gender="";//성별
    int age=0;//나이

    //주민번호에서 성별추출하기 -1
    String index = jumin.substring(7,8);
    
  	//주민번호에서 성별추출하기 -2
    int cnt = jumin.indexOf('-');
    String index2 = jumin.charAt(cnt+1)+"";

    //주민번호에서 년도 추출
    String year = jumin.substring(0,2);
    
  	//나이 및 성별 계산
    //if("1256".contains(index2)){
    if("1256".contains(index)) {
       age = 2025-(1900+Integer.parseInt(year));
       if("15".contains(index)) {
          gender="남";
       }else {
          gender="여";
       }
    }else {
       age = 2025-(2000+Integer.parseInt(year));
       if("37".contains(index)) {
          gender="남";
       }else {
          gender="여";
       }
    }

	
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
			<td colspan="5" class="title">화원정보 출력</td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td>연락처</td>
			<td>성별</td>
			<td>나이</td>
			<td>직업</td>
		</tr>
		<tr>
			<td><%= name %></td>
			<td><%= tel %></td>
			<td><%= gender %></td>
			<td><%= age %></td>
			<td><%= job %></td>
		</tr>
		
		<tr>
			<td colspan="5" class="btn">
				<a href="">확인</a>
				<a href="">돌아가기</a>
			</td>
		</tr>
	</table>
</body>
</html>