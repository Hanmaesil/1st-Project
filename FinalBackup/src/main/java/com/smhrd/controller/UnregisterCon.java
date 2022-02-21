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

@WebServlet("/UnregisterCon")
public class UnregisterCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		//세션에 저장된 닉네임 받기(안받아도됨)
//		HttpSession session = request.getSession();
//		String nick = (String) session.getAttribute("nick");
		
		//입력한 값 받기
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//dao객체생성
		A_MemberDAO dao = new A_MemberDAO();
		
		int cnt = dao.memberUnregister(id,pw);
		
		if(cnt >0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('회원탈퇴가 완료되었습니다. 이용해주셔서 감사합니다');"); 
			out.print("location.href = 'main.jsp';"); 
			out.print("</script>");
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('입력하신 정보가 틀렸습니다. 다시 입력해주세요');");
			out.print("location.href = 'Unregister.html';"); 
			out.print("</script>");
		}
		
		
		
		
		
		
	}

}
