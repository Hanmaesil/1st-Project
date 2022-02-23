package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.A_MemberDAO;

public class LoginCon  implements iCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



		// 인코딩
		request.setCharacterEncoding("utf-8");
		
	
		//입력한 데이터 받기
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//1. dao 객체 만들기
		A_MemberDAO dao = new A_MemberDAO();
		
		//2. dto형식으로 만들기
		String nick = dao.memberLogin(id,pw);
		
		
		if(nick != null) {
			HttpSession session = request.getSession();
			session.setAttribute("nick", nick);
			response.sendRedirect("main2.jsp");
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인 실패');");
			out.print("location.href = 'main.jsp';");
			out.print("</script>");
		}
		
	}

}
