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
import com.smhrd.model.A_FlavorDAO;


public class FlavorCon  implements iCommand {

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
		String flavor = request.getParameter("index");
		System.out.println(flavor);

		// dao 객체 생성!
		A_FlavorDAO dao = new A_FlavorDAO();

		// 배열 생성
		ArrayList<String> flavorlist = dao.flavor(sort, flavor);

		// 대분류 선택시 해당 설명과 이미지를 가져오기
		for (int i = 0; i < flavorlist.size(); i++) {
			jarray.add(gson.toJson(flavorlist.get(i)));
		}

		response.setContentType("text/plain; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.print(jarray);

	}

}
