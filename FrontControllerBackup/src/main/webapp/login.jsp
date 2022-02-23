<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  회원가입 -->
	<form action = "LoginCon.do" method="post" >
		<table border = "1">
			<tr>
				<td>id</td>
				<td><input type = "text" name ="id"></td>
			</tr>
			<tr>
				<td>pw</td>
				<td><input type = "password" name ="pw"></td>
			</tr>
			<tr align = "center">
				<td colspan="2">
					<input type = "submit" value ="로그인">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>