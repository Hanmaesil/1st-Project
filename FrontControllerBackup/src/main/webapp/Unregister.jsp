<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<!--  회원탈퇴 -->
	<form action = "UnregisterCon.do" method="post">
		<table border = "1">
			<tr>
				<td>id</td>
				<td><input type = "text" name = "id"></td>
			</tr>
			<tr>
				<td>pw</td>
				<td><input type = "password" name= "pw"></td>
			</tr>
			<tr align = "center">
				<td><input type = "submit" value ="회원탈퇴"></td>
				<td><input type = "submit" value = "취소" onclick = "main2.jsp"></td>
			</tr>
		</table>
	</form>
</body>
</html>