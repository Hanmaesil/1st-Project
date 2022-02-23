<%@page import="com.smhrd.model.A_ReplyDTO"%>
<%@page import="com.smhrd.model.A_ReplyDAO"%>
<%@page import="com.smhrd.model.A_BoardDTO"%>
<%@page import="com.smhrd.model.A_BoardDAO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
//게시글을 꺼내오기 위한 번호(쿼리스트링으로 받기)
int num = Integer.parseInt(request.getParameter("bo_num"));
//댓글을 달기위해 기준이 되는 게시글 번호를 세션에 저장하기
HttpSession bo_num = request.getSession();
System.out.println("선택한 게시판 번호는"+num);
bo_num.setAttribute("bo_num", num);

//게시글에 글 출력을 위한 객체 생성
A_BoardDAO dao = new A_BoardDAO();
ArrayList<A_BoardDTO> view = dao.content(num);

//게시판에 댓글을 출력하기 위한 객체 생성
A_ReplyDAO r_dao = new A_ReplyDAO();
ArrayList<A_ReplyDTO> reply = r_dao.Output(num);

//본인 확인용 
String nick = (String)session.getAttribute("nick");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<!--뒤로가기 버튼  -->
	<button onclick="location.href='Board.jsp'">뒤로가기</button>

	<!-- 게시물 출력, 수정,삭제, 댓글기능  -->
	
		
		<%if(view.get(0).getNick().equals(nick)){%>
			<a href = "WriterUpdate.jsp?bo_num=<%=view.get(0).getBo_num()%>">수정</a>
			<a onclick = "return confirm('정말로 삭제하시겠습니까?')" href = "WriterDeleteCon.do?bo_num=<%=view.get(0).getBo_num()%>">삭제</a>
			
		<%}; %>
		
		
		
		
		
	<table border="1">
		<tr>
			<td>게시글 이름</td>
			<td><%=view.get(0).getBo_title()%></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=view.get(0).getNick()%></td>
		</tr>
		<tr>
			<td>게시글 내용</td>
			<td><%=view.get(0).getBo_content() %></td>
		</tr>
		<tr>
			<td>작성 시간</td>
			<td><%= view.get(0).getBo_date() %></td>
		</tr>
		
	</table>
	<table border = "1">
		
			<%
			//댓글출력
			for(int i = reply.size() -1 ; i >= 0; i--){
				out.print("<tr>");
				out.print("<td>"+ reply.get(i).getNick() + "</td>");
				out.print("<td>"+ reply.get(i).getRe_coment() + "</td>");
				out.print("<td>"+ reply.get(i).getRegdate() + "</td>");
				out.print("</tr>");
			}
			
			
			%>
		
	</table>

	<form action="ReplyCon.do"   method="post">
		<table border="1">
			<tr>
				<td><input type="text" name="re_coment"></td>
				
				<td><input type="submit" value="등록"></td>
			</tr>
		</table>

	</form>


</body>
</html>