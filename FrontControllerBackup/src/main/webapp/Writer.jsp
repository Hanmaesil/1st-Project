<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%String nick = (String)session.getAttribute("nick"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 글작성  -->
	<%
	//로그인 안되어있으면 로그인 창으로 이동
	if(nick == null) {
		response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('로그인시 사용가능합니다.');");
		out.print("location.href = 'login.jsp';"); 
		out.print("</script>");
	}else{
	%>
	<form action = "WriterCon.do" method="post">
		<table border = "1">
			<tr>
				<th><input type = "text" name = "title"></th>
			</tr>
			<tr>
				<td><input type = "text" name = "content" maxlength="50"></td>
			</tr>
			<tr>
				<td><input type = "submit" value ="글쓰기"></td>
			</tr>
		</table>
	</form>
	<%} %>
	
	
	
</body>
</html>