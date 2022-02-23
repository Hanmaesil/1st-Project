<%@page import="com.smhrd.model.A_BoardDTO"%>
<%@page import="com.smhrd.model.A_BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
//게시판에 글 출력을 위한 객체 생성
A_BoardDAO dao = new A_BoardDAO();
ArrayList<A_BoardDTO> boardlist = dao.Output();
//게시판 번호를 담을 세션
//HttpSession bo_num = request.getSession();

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 게시판 목록 출력, 글작성 페이지  -->
	<table border = "1">
		<tr>
			<td>번호</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>작성날짜</td>
		</tr>
		<%
		
		for(int i = 0; i < boardlist.size(); i++){
			out.print("<tr>");
			out.print("<td>" + (i+1) + "</td>");
			out.print("<td><a href = Content.jsp?bo_num="+boardlist.get(i).getBo_num() + ">" + boardlist.get(i).getBo_title() + "</a></td>");
			out.print("<td>" + boardlist.get(i).getNick() + "</td>");
			out.print("<td>" + boardlist.get(i).getBo_date() + "</td></tr>");
			int num = boardlist.get(i).getBo_num();
			session.setAttribute("bo_num", num);
		}
	
		%>
		<tr>
			<td clospan ="3"><a href = Writer.jsp>글작성</a></td>
		</tr>
	</table>
	
	
	
</body>
</html>