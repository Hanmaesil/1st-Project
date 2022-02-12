<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%

String nick = (String)session.getAttribute("nick");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<a href = "Update.jsp">정보수정</a>
	<a href = "Unregister.jsp">회원탈퇴</a>
	<a href = "Logout.jsp">로그아웃</a>
	<br><br>
	<strong><%= nick %> 님 환영합니다~</strong>
	<a href = "Board.jsp">게시판</a>
	
	
</body>
</html>