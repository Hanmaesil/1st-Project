<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 회원정보 수정  -->
<form action = "UpdateCon.do" method="post">
		<table border = "1">
			<tr>
				<td>pw</td>
				<td><input type = "password" name = "pw"></td>
			</tr>
 			
			<tr>
				<td>phone</td>
				<td><input type = "text" name = "phone"></td>
			</tr>
			<tr align = "center">
				<td colspan="2">
					<input type = "submit" value ="회원정보 수정">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>