package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.A_JjimDAO;

@WebServlet("/JjimCon")
public class JjimCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ���ڵ�
		request.setCharacterEncoding("utf-8");

		// �г��� ��������
		// �ϴ� ���Ƿ� �ο� -> ���ǿ� ����� �г��� �������� ��
		//String nick = "�׽�Ʈ";
		
		//����������
		//1�̸� ���� 0 �̸� ������
		int Jcnt = Integer.parseInt(request.getParameter("bSubmit"));
		String nick = request.getParameter("nick");
		int num = Integer.parseInt( request.getParameter("num"));
		
		System.out.println("���Ͽ� �Ѿ�� �� ������ > " + Jcnt);
		System.out.println("���Ͽ� �Ѿ�� �г����� > " + nick);
		System.out.println("���Ͽ� �Ѿ�� �ѹ����� > " + num);
		
		A_JjimDAO dao = new A_JjimDAO();
		
		int cnt = dao.cnt(Jcnt, nick, num);
		
		

	}

}
