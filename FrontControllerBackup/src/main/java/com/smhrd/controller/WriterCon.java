package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.A_BoardDAO;
import com.smhrd.model.A_BoardDTO;

public class WriterCon  implements iCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		//세션에 저장된 닉네임 가져오기
		HttpSession session = request.getSession();
		String nick = (String) session.getAttribute("nick");
		
		
		
		
		//입력받은 값 가져오기
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//dao 객체 생성
		A_BoardDAO dao = new A_BoardDAO();
		
		int cnt = dao.Input(new A_BoardDTO(0, nick, title, content, null));
		
		if(cnt > 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('글작성 완료');");
			out.print("location.href = 'Board.jsp';");
			out.print("</script>");
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('글작성 실패');");
			out.print("location.href = 'Board.jsp';"); 
			out.print("</script>");
		}
		
		
		
		
		
	}

}
