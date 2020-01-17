package dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "deptinsert", urlPatterns = { "/deptinsert.do" })
public class DeptServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter dept = response.getWriter();
		System.out.println("서블릿");
		int result = 0;
		String deptNo = request.getParameter("deptNo");
		String deptName = request.getParameter("deptName");
		String loc = request.getParameter("loc");
		String tel = request.getParameter("tel");
		String mgr = request.getParameter("mgr");
		//hyperlink는 무조건 get방식 이다.
/*		System.out.println("부서코드=>"+deptNo);
		System.out.println("부서명=>"+deptName);
		System.out.println("부서위치=>"+loc);
		System.out.println("전화번호=>"+tel);
		System.out.println("관리자=>"+mgr);*/
		//2.비지니스 메소드 call
		DeptDAO dao = new DeptDAOImpl();
		DeptDTO dept1 = new DeptDTO(deptNo,deptName,loc,tel,mgr);
		result = dao.insert(dept1); 
		
		//3. 데이터 공유
	    request.setAttribute("insertresult", result);
	 	
		//4. 응답화면으로 요청 재지정
		RequestDispatcher rd = request.getRequestDispatcher("/dept/insertResult.jsp");
		rd.forward(request, response);
	}
}
