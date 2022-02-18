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

import model.A_SearchDAO;
import model.A_SearchDTO;

@WebServlet("/ResultCon")
public class ResultCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
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
		//맛
		String[] taste = request.getParameterValues("tasteList");
		int size = taste.length;
		System.out.println("맛의 길이는" + size);
		System.out.println(taste[0]);
		//향
		String[] flavor = request.getParameterValues("flavorList");
		int size2 = flavor.length;
		System.out.println("향의 길이는 " + size2);
		
		//옵션
		String option = request.getParameter("option");
		if(option == null) {
			option = "or";
		}
		System.out.println("선택한 옵션은 > " + option);
		
//		if(flavor.length == 0) {
//			flavor[0] = "";
//		};
		//System.out.println(flavor[0]);
		
		// dao 객체 생성
		A_SearchDAO dao = new A_SearchDAO();
		// dto타입의 배열 생성
		ArrayList<A_SearchDTO> list = dao.result(sort, taste, flavor, option);
		
		System.out.println("선택한 옵션은 " + option + "이며 총 갯수는 > " + list.size());

		// 결과 가져오기
		for (int i = 0; i < list.size(); i++) {
			jarray.add(gson.toJson(list.get(i)));
		}

		response.setContentType("text/plain; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.print(jarray);

	}

}
