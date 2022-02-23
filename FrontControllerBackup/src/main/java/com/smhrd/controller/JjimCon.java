package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.A_JjimDAO;


public class JjimCon  implements iCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 인코딩
		request.setCharacterEncoding("utf-8");

		// 닉네임 가져오기
		// 일단 임의로 부여 -> 세션에 저장된 닉네임 가져오면 됨
		//String nick = "테스트";
		
		//값가져오기
		//1이면 찜등록 0 이면 찜해제
		int Jcnt = Integer.parseInt(request.getParameter("bSubmit"));
		String nick = request.getParameter("nick");
		int num = Integer.parseInt( request.getParameter("num"));
		
		System.out.println("찜목록에 넘어온 찜 유무는 > " + Jcnt);
		System.out.println("찜목록에 넘어온 닉네임은 > " + nick);
		System.out.println("찜목록에 넘어온 넘버링은 > " + num);
		
		A_JjimDAO dao = new A_JjimDAO();
		
		int cnt = dao.cnt(Jcnt, nick, num);
		
		

	}

}
