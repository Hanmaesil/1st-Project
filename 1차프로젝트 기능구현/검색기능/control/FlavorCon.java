package Controller;

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

import model.A_FlavorDAO;
import model.A_FlavorDTO;

@WebServlet("/FlavorCon")
public class FlavorCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ���ڵ�
		request.setCharacterEncoding("utf-8");
		// gson��ü����
		Gson gson = new Gson();
		// JsonArray ��ü ����
		JsonArray jarray = new JsonArray();

		// sort, �ʼ� ��������
		int sort = Integer.parseInt(request.getParameter("num"));
		System.out.println(sort);
		String flavor = request.getParameter("index");
		System.out.println(flavor);

		// dao ��ü ����!
		A_FlavorDAO dao = new A_FlavorDAO();

		// �迭 ����
		ArrayList<String> flavorlist = dao.flavor(sort, flavor);

		// ��з� ���ý� �ش� ����� �̹����� ��������
		for (int i = 0; i < flavorlist.size(); i++) {
			jarray.add(gson.toJson(flavorlist.get(i)));
		}

		response.setContentType("text/plain; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.print(jarray);

	}

}
