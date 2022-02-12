<%@page import="com.smhrd.model.A_BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.smhrd.model.A_BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
//게시판에 글 출력을 위한 객체 생성
A_BoardDAO dao = new A_BoardDAO();
ArrayList<A_BoardDTO> boardlist = dao.Output();

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
			<td>번호</td>
			<td>글제목</td>
			<td>작성자</td>
		</tr>
		<%
		for(int i = 0; i < boardlist.size(); i++){
			out.print("<tr>");
			out.print("<td>" + boardlist.get(i).getNum() + "</td>");
			out.print("<td><a href = Content.jsp?bo_num="+boardlist.get(i).getNum() + ">" + boardlist.get(i).getTitle() + "</a></td>");
			out.print("<td>" + boardlist.get(i).getNick() + "</td>");
		}
		
		%>
		<tr>
			<td clospan ="3"><a href = Writer.jsp>글작성</a></td>
		</tr>
	</table>
	
	
	
</body>
</html>