package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.smhrd.model.A_JjimDAO;
import com.smhrd.model.A_JjimDTO;


public class JjimprintCon  implements iCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("utf-8");
		// gson객체생성
		Gson gson = new Gson();
		// JsonArray 객체 생성
		JsonArray jarray = new JsonArray();

		// 닉네임 가져오기
		String nick = request.getParameter("nick");
		// 찜된것들만 가져오기 위한 변수
		int cnt = 1;

		// dao 객체 생성
		A_JjimDAO dao = new A_JjimDAO();

		// dto타입 배열 생성
		ArrayList<A_JjimDTO> list = dao.print(nick, cnt);

		for (int i = 0; i < list.size(); i++) {
			jarray.add(gson.toJson(list.get(i)));
		}

		response.setContentType("text/plain; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.print(jarray);

	}

}
