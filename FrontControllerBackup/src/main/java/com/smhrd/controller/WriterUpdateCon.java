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

public class WriterUpdateCon  implements iCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		//세션에 저장된 번호 가져오기
		HttpSession session = request.getSession();
		int bo_num = (int)session.getAttribute("bo_num");
		System.out.println("변경할 글의 게시판 번호는 " + bo_num);
		
		//업데이트할 내용
		String bo_title = request.getParameter("title");
		String bo_content = request.getParameter("content");
		
		//dao객체 생성
		A_BoardDAO dao = new A_BoardDAO();
		
		int cnt = dao.Update(bo_num, bo_title, bo_content);
		
		if(cnt > 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('글수정 완료');");
			out.print("location.href = 'Content.jsp?bo_num="+ bo_num +"';");
			out.print("</script>");
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('글수정 실패');");
			out.print("location.href = 'Board.jsp';"); 
			out.print("</script>");
		}
		
	}

}
