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
import com.smhrd.model.A_TasteDAO;


public class TasteCon  implements iCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 인코딩
		request.setCharacterEncoding("utf-8");
		// gson객체생성
		Gson gson = new Gson();
		// JsonArray 객체 생성
		JsonArray jarray = new JsonArray();

		// sort, 초성 가져오기
		int sort = Integer.parseInt(request.getParameter("num"));
		System.out.println(sort);
		String taste = request.getParameter("index");
		System.out.println(taste);

		// dao 객체만들기
		A_TasteDAO dao = new A_TasteDAO();

		// 배열만들기
		ArrayList<String> tastelist = dao.taste(sort, taste);
		

		// 대분류 선택시 해당 설명과 이미지를 가져오기
		for (int i = 0; i < tastelist.size(); i++) {
			jarray.add(gson.toJson(tastelist.get(i)));
		}

		response.setContentType("text/plain; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.print(jarray);

	}

}
