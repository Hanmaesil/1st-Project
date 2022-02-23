package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.A_MemberDAO;
import com.smhrd.model.A_MemberDTO;

public class JoinCon  implements iCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//페이지연결확인
		System.out.println("연결완료");
		
		
		//인코딩
		request.setCharacterEncoding("utf-8");
		
		
		//입력받은 값 가져오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		String phone = request.getParameter("phone");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String birth = year+"-"+month+"-"+day;
		
		
//		int sex =  Integer.parseInt(request.getParameter("sex"));
		//성별 숫자로 변환
		int sex;
		
		if(request.getParameter("sex").equals("남자")) {
			sex = 0;
		}else {
			sex = 1;
		}

		
		//ajax로 비밀번호 확인 기능 추가할것
		
		
		
		//회원가입
		//1. dao객체 생성
		A_MemberDAO dao = new A_MemberDAO();
		//2. dto타입으로 받기
		int cnt = dao.memberJoin(new A_MemberDTO(id, pw, nick, phone, birth, sex));
		
		//3. 리턴받기
		
		if(cnt > 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('회원가입 완료');");
			out.print("location.href = 'main.jsp';");
			out.print("</script>");
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('회원가입 실패...!');");
			out.print("location.href = 'Join.html';"); 
			out.print("</script>");
		}
		
		
		
	}

}
