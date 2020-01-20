package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "member/insert", urlPatterns = { "/member/insert.do" })
public class MemberInsertServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//문자 인코딩해주기
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter dept = response.getWriter();
		int result = 0;
		String deptno = request.getParameter("deptno");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String addr = request.getParameter("addr");
		String grade = request.getParameter("grade");
		int point = Integer.parseInt(request.getParameter("point"));
		//2. 비지니스 메소드 call
		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO(id, pass, name, addr, deptno, grade, point);
		result = dao.insert(member);
		//3.데이터 공유
		request.setAttribute("insertResult", result);
		System.out.println("InsertServlet실행완료");
		//4.응답화면으로 요청 재지정
		RequestDispatcher rd = request.getRequestDispatcher("/member/insertResult.jsp");
		rd.forward(request, response);
	}
}
