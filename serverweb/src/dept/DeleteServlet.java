package dept;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "delete", urlPatterns = { "/delete.do" })
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		//1.요청정보추출
		PrintWriter del = response.getWriter();
		System.out.println("서블릿");
		String deptno = request.getParameter("deptno");
		//2.비지니스메소드 호출
		DeptDAO dao = new DeptDAOImpl();
		int result = 0;
		result = dao.delete(deptno);
		//3.요청재지정
		response.sendRedirect("/serverweb/list.do");
/*		del.print("<html>");
		del.print("<body>");
		//위 두개는 생략해도 무관하다.
		del.print("<h1>삭제성공</h1>");
		del.print("<hr/>");
		del.print("<h3>"+result+"개 부서삭제 성공</h3>");
		del.print("<a href='/serverweb/list.do' target='_blank'>목록보기</a>");
		del.print("</body>");
		del.print("</html>");*/		
	}

}
