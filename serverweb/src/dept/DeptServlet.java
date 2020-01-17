package dept;

import java.io.IOException;
import java.io.PrintWriter;

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
		DeptDTO dept1 = new DeptDTO(deptNo,deptName,loc,tel,mgr);
		DeptDAO dao = new DeptDAOImpl();
		result = dao.insert(dept1); 
	/*	//3. 응답메시지 생성
		dept.print("<html>");
		dept.print("<body>");
		//위 두개는 생략해도 무관하다.
		dept.print("<h1>부서정보</h1>");
		dept.print("<hr/>");
		dept.print("<h3>"+result+"개 부서등록 성공</h3>");
		dept.print("</body>");
		dept.print("</html>");*/
		//3. 응답화면으로 요청재지정
		response.sendRedirect("/serverweb/dept/insertResult.html");	
	}
}
