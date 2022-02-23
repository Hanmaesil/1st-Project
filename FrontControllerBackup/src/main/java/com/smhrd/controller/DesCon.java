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
import com.smhrd.model.A_DesDAO;
import com.smhrd.model.A_DesDTO;


public class DesCon implements iCommand{

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//인코딩
		request.setCharacterEncoding("utf-8");
		//gson객체생성
		//Gson gson = new Gson();
		Gson gson = new Gson();
		//JsonArray 객체 생성
		JsonArray jarray = new JsonArray();
		
		
		 int sort = Integer.parseInt(request.getParameter("num"));
		 System.out.println("가져온 대분류는 > " + sort);
		 
		 
		
		//dao객체 만들기
		A_DesDAO dao = new A_DesDAO();
		//배열만들기
		ArrayList<A_DesDTO> deslist = dao.des(sort);
		
		//대분류 선택시 해당 설명과 이미지를 가져오기
		for(int i = 0; i < deslist.size(); i++) {
			jarray.add(gson.toJson(deslist.get(i)));
		}
		
		response.setContentType("text/plain; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.print(jarray);
		
		
		
		
		
		
		
		
		
		
	}

}
