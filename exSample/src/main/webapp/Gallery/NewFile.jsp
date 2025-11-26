<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<input type="file" id="file" accept="image/*">
<br><br>
<img id="previewImg" style="max-width:200px; display:none;">

<script>
$("#file").on("change", function() {
    let file = this.files[0];
    if (!file) return;

    let imgURL = URL.createObjectURL(file);
    $("#previewImg").attr("src", imgURL).show();
});
</script>

</body>
</html>