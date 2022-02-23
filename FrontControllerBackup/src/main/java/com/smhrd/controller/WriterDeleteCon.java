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

public class WriterDeleteCon  implements iCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 인코딩
		request.setCharacterEncoding("utf-8");

		// 세션에 저장된 번호 가져오기
		HttpSession session = request.getSession();
		int bo_num = (int) session.getAttribute("bo_num");
		System.out.println("삭제할 글의 게시판 번호는 " + bo_num);
		String nick = (String)session.getAttribute("nick");
		System.out.println("현재 접속한 닉네임은 >" + nick);
		
		
		//dao 객체 만들기
		A_BoardDAO dao = new A_BoardDAO();
		
		int cnt = dao.Delete(bo_num, nick);
		

		if(cnt > 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('글삭제 완료');");
			out.print("location.href = 'Board.jsp';");
			out.print("</script>");
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('글삭제 실패');");
			out.print("location.href = 'Board.jsp';"); 
			out.print("</script>");
		}
		
		
		
		

	}

}
