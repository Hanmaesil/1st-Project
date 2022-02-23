package com.smhrd.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, iCommand> map;
	
	
	public void init() throws ServletException{
		
		map = new HashMap<String, iCommand>();
		
		map.put("/DesCon.do", new DesCon());
		map.put("/FlavorCon.do", new FlavorCon());
		map.put("/JjimCon.do", new JjimCon());
		map.put("/JjimDeleteCon.do", new JjimDeleteCon());
		map.put("/JjimprintCon.do", new JjimprintCon());
		map.put("/JoinCon.do", new JoinCon());
		map.put("/LoginCon.do", new LoginCon());
		map.put("/ReplyCon.do", new ReplyCon());
		map.put("/ResultCon.do", new ResultCon());
		map.put("/TasteCon.do", new TasteCon());
		map.put("/UnregisterCon.do", new UnregisterCon());
		map.put("/UpdateCon.do", new UpdateCon());
		map.put("/WriterCon.do", new WriterCon());
		map.put("/WriterDeleteCon.do", new WriterDeleteCon());
		map.put("/WriterUpdateCon.do", new WriterUpdateCon());
		
	}
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("들어온 요청 : " + command);
		
		iCommand com = map.get(command);
		com.execute(request, response);
		
		
		
		
		
		
		
		
	}

}
