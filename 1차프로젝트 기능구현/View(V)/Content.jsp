<%@page import="com.smhrd.model.A_BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.smhrd.model.A_BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
//게시글을 꺼내오기 위한 번호(쿼리스트링으로 받기)
int num = Integer.parseInt(request.getParameter("bo_num")); 
System.out.println(num);
//게시글에 글 출력을 위한 객체 생성
A_BoardDAO dao = new A_BoardDAO();
ArrayList<A_BoardDTO> view = dao.content(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border = "1">
		<tr>
			<td><%= view.get(0).getTitle() %></td>
		</tr>
		<tr>
			<td><%= view.get(0).getNick() %></td>
		</tr>
		<tr>
			<td><%= view.get(0).getContent() %></td>
		</tr>
	</table>
</body>
</html>