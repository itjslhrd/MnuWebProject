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
		function golfFrm_send(){
			
			golfFrm.submit();//전송하라
		}
		
		function golfFrm_reset(){
			alert("모든 정보를 지우고 다시 입력합니다");
			golfFrm.reset();
			golfFrm.name.focus();
		}	
		
		function mem_check(){
			golfFrm.gno.value=golfFrm.gname.value;
		}
		
		function price_check(){
			var str = golfFrm.glecture.value.split(",");
			alert(str[0] +","+str[1]);
			if(golfFrm.gno.value>=20000){
				golfFrm.gprice.value = str[1] * 0.5;
			}else{
				golfFrm.gprice.value = str[1];
			}
			golfFrm.code.value=str[0];
		}
	</script>
</head>
<body>
	<form name="golfFrm" method="post" action="golf_mem_write_ok.jsp">
		<table>
			<tr>
				<td colspan="2" class="title">골프 수강 신청</td>
			</tr>
			<tr>
				<td>수강월</td>
				<td><input type="text" name="gdate" >2025년3월=> 202503</td>
			</tr>
			<tr>
				<td>회원명</td>
				<td><select name="gname" onchange="mem_check()">
						<option>회원을 선택하세요</option>
						<option value="10001">[10001] 김회원</option>
						<option value="10002">[10002] 오회원</option>
						<option value="10003">[10003] 윤회원</option>
						<option value="20001">[20001] 홍회원</option>
						<option value="20002">[20002] 박회원</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>회원번호</td>
				<td>
					<input type="text" name="gno" readonly>	
				</td>
			</tr>
			<tr>
				<td>강의장소</td>
				<td>
					<select name="gclass">
						<option>강의 장소를 선택하세요</option>
						<option value="제1강의장">제1강의장</option>
						<option value="제2강의장">제2강의장</option>
						<option value="제3강의장">제3강의장</option>
						<option value="제4강의장">제4강의장</option>
						<option value="제5강의장">제5강의장</option>
					</select> 
				</td>
			</tr>
			<tr>
				<td>강의선택</td>
				<td>
					<select name="glecture" onchange="price_check()">
						<option>강의을 선택하세요</option>
						<option value="100,100000">[100] 초급반</option>
						<option value="200,200000">[200] 중급반</option>
						<option value="300,300000">[300] 고급반</option>
						<option value="400,400000">[400] 심화반</option>
					</select>
					<input type="hidden" name="code">
				</td>
			</tr>
			<tr>
				<td>수강료</td>
				<td>
					<input type="text" name="gprice">	
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btn">
					<input type="button" value="수강신청" onclick="golfFrm_send()">
					<input type="button" value="다시쓰기" onclick="golfFrm_reset()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>