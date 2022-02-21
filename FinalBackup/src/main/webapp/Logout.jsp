<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그아웃  -->
	<%
	session.invalidate();
	response.sendRedirect("main.jsp");
	%>
</body>
</html>