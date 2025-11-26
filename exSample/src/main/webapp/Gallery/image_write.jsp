<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
function readImage(input) {
    // input 태그에 이미지를 업로드 한 경우
    if(input.files && input.files[0]) {
    	alert("AAA");
            // FileReader 생성
            const reader = new FileReader();
            reader.onload = function(e){
            	//const previewImage = document.getElementById("img태그 id값");
                const previewImage = document.getElementById("dummy-image");
                previewImage.src = e.target.result;
            }
            // reader가 업로드된 이미지의 경로를 읽는다.
            reader.readAsDataURL(input.files[0])
        }
    }
    // input 태그에 change 이벤트 설정
    //const inputImage = document.getElementById("input태그 id값");
    const inputImage = document.getElementById("gds_thumbnail1");
    inputImage.addEventListener("change", function(e){
    	alert("AAA");
        readImage(e.target);
    });

</script>

</head>
<body>
<form name=input method=post enctype="multipart/form-data">
<tr>
    <th style="text-align:center;">대표이미지</th>
    <td class="content"> 
         <img style="width: 400px;" id="dummy-image" 
         src="<%=request.getContextPath()%>/Gallery/images/jsl.jpg">
         <input type="file" id="gds_thumbnail1" name="gds_thumbnail1">
    </td>
</tr>
</form>

</body>
</html>