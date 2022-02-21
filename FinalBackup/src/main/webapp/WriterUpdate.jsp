<%@page import="com.smhrd.model.A_BoardDTO"%>
<%@page import="com.smhrd.model.A_BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String nick = (String)session.getAttribute("nick");
//게시글을 꺼내오기 위한 번호(쿼리스트링으로 받기)
int num = Integer.parseInt(request.getParameter("bo_num"));
HttpSession bo_num = request.getSession();

System.out.println(num);
bo_num.setAttribute("bo_num", num);

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
	<!-- 글수정 페이지  -->
	<form action = "WriterUpdateCon" method="post">
		<table border = "1">
			<tr>
				<td>게시글 이름</td>
				<td><input type = "text" name = "title" value= "<%=view.get(0).getBo_title()%>"></td>
			</tr>
			<tr>
				<td>게시글 내용</td>
				<td><input type = "text" name = "content" maxlength="50" value = "<%=view.get(0).getBo_content() %>"></td>
			</tr>
			<tr>
				<td><input type = "submit" value ="수정"></td>
			</tr>
		</table>
	</form>
	
	
	
</body>
</html>