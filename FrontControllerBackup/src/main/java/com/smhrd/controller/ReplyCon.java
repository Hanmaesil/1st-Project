package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.A_ReplyDAO;
import com.smhrd.model.A_ReplyDTO;

public class ReplyCon  implements iCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 인코딩
		request.setCharacterEncoding("utf-8");

		// 세션에 저장된 bo_num, nick 가져오기
		HttpSession bo_num = request.getSession();
		HttpSession session = request.getSession();
		int re_bo_num = (int) bo_num.getAttribute("bo_num");
		String nick = (String) session.getAttribute("nick");

		// 들어오는지 확인
		System.out.println(re_bo_num);
		System.out.println(nick);

		// 입력받은 값 가져오기

		String re_coment = request.getParameter("re_coment");

		// 어디가 문제신가요??
		// 지금 쿼리스트링으로 숫자를 받아왔는데 댓글 다는기능에서 댓글을 달고 댓글을 단 페이지로 이동하고 싶은데 오류가 나서요 일단 보여드릴까요?
		// 넵넵
		//db에는 들어가는데 저렇게 오류가 나오더라구요
		
		
		// dao객체 생성
		A_ReplyDAO dao = new A_ReplyDAO();

		
		// 여기서 값이 넘어갈때 null 값이 넘어가는 것 같아요
		// 여기서 넘기는 값이 db로 들어가는데 db에는 잘 들어가요
		
		//아까 그래서 content.jsp 말고 다른 페이지로 이동시켜보니까 다른페이지로는 잘 이동이 되는데 저 페이지ㅁ로 이동하려고만 하면 오류가 나오더라구요
		int cnt = dao.Input(new A_ReplyDTO(0, re_bo_num, nick, re_coment, null, 0));

		// 리턴받기
		if (cnt > 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('댓글작성완료');");
			out.print("location.href = 'Content.jsp?bo_num="+ re_bo_num +"';");  // 오호...... 어허.... 코드 다 맞는데.... 안넘어가는게 저도 의문이네욧....
			// 이게 계속 해보니까 드는 생각인데 혹시
			// 쿼리스트링으로 받아온 값은 페이지 다시 접속하면 사라지나요?
			//null값으로 나오는게 그 전페이지에서 쿼리스트링으로 num을 못가져와서 null이라서 오류가 뜨는거 같아서요
			// 그럼 테스트로 이전 페이지에서 넘어올때 num 값을 같이 가져와서 변수에 담아 뒀다가 여기서 다시 이동할 때 같이 보내보는게 어떨까요?
			//그래서 이렇게 해봤는데도 안되더라구요
			// 혹시 여기 맞나 확인해주실수 있을까요? 저걸로 일단 실행해서 또 발생하는 오류를 확인해봅시다!
			//제가 해볼까요? 넵넵! 한번 해주세용!
			//저기 num 가져온걸로 쿼리스트링 형태로 바꿔서 url에 띄울려고 한거에요 실행해볼게요
			// 저렇게 나오더라구요...
			
			// 일단 값은 넘어가긴 하는거 같은데 문자형태로 가니까 저거 잘 활용하면 가능하지 않을까요?
			// " 2" 공백까지 포함해서 들어가는것 같아서.. 저거가 쪼끔 걸리네용
			// 그럼 변환해서 한번 해보겠습니다!
			
			// 넵넵 한번 해보시구 안되면 병관쌤한테도 한번 요청드려 봅시다 ㅜㅜ
			//넵! 감사합니다 ㅎㅎ
			out.print("</script>");
			//System.out.println();
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('댓글작성실패');");
			out.print("location.href = 'Content.jsp';");
			out.print("</script>");
		}

	}

}
