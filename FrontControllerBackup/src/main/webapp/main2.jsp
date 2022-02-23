,<%@ page language="java" contentType="text/html; charset=utf-8"
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
	<!-- 로그인시 페이지  -->
	<a href = "Update.jsp">정보수정</a>
	<a href = "Unregister.jsp">회원탈퇴</a>
	<a href = "Logout.jsp" id = "logout" onclick = "deleteJjim(event)">로그아웃</a>
	<br><br>
	<strong><%= nick %> 님 환영합니다~</strong>
	<a href = "Board.jsp">게시판</a>
	<a href = "Search.jsp">술 검색</a>
	
	<script src="jquery-3.6.0.min.js"></script>
		<script type="text/javascript">
		
		
		let nick = "<%=nick%>";
		console.log(nick)
		
		function deleteJjim(event){
			if(event.target.click){
				$.ajax({
					url : "JjimDeleteCon.do",
					data : {"nick" : nick},
					dataType : "json",
					success : function(result){
						alert("로그아웃")
					}

				});
			}
		}
		
		</script>
	
	
	
</body>
</html>