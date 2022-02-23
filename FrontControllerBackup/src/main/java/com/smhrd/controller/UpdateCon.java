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

public class UpdateCon  implements iCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//인코딩
		request.setCharacterEncoding("utf-8");
		
		
		//세션에 저장된 닉네임 가져오기
		HttpSession session = request.getSession();
		String nick = (String) session.getAttribute("nick");
		
		//입력받은 값
		String re_pw = request.getParameter("pw");
		String re_nick = request.getParameter("nick");
		String re_phone = request.getParameter("phone");
		
		//ajax로 비밀번호 확인 구현
		
		//dao 객체 생성
		A_MemberDAO dao = new A_MemberDAO();
		
		int cnt = dao.memberUdate(re_pw, re_nick, re_phone, nick);
		
		
		if(cnt >0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			session.setAttribute("nick", nick);
			out.print("<script>");
			out.print("alert('회원정보가 변경되었습니다.');"); //alert : 중간에 작은 창을 띄어준다
			out.print("location.href = 'main2.jsp';"); // 확인키 누르면 이동하는 장소(내,외부 전부 가능)
			out.print("</script>");
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('회원정보 수정 실패...!');"); //alert : 중간에 작은 창을 띄어준다
			out.print("location.href = 'Updatew.html';"); // 확인키 누르면 이동하는 장소(내,외부 전부 가능)
			out.print("</script>");
		}
		
		
		
		
	}

}
