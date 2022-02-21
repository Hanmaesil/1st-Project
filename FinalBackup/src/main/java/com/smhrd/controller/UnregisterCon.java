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
		
		// ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		//���ǿ� ����� �г��� �ޱ�(�ȹ޾Ƶ���)
//		HttpSession session = request.getSession();
//		String nick = (String) session.getAttribute("nick");
		
		//�Է��� �� �ޱ�
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//dao��ü����
		A_MemberDAO dao = new A_MemberDAO();
		
		int cnt = dao.memberUnregister(id,pw);
		
		if(cnt >0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('ȸ��Ż�� �Ϸ�Ǿ����ϴ�. �̿����ּż� �����մϴ�');"); 
			out.print("location.href = 'main.jsp';"); 
			out.print("</script>");
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('�Է��Ͻ� ������ Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���');");
			out.print("location.href = 'Unregister.html';"); 
			out.print("</script>");
		}
		
		
		
		
		
		
	}

}