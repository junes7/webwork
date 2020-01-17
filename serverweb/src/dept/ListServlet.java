package dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "list", urlPatterns = { "/list.do" })
public class ListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("euc-kr");
	response.setContentType("text/html;charset=euc-kr");
	//1.요청정보추출
	PrintWriter list = response.getWriter();
	System.out.println("서블릿");
	//2.비지니스메소드 호출
	DeptDAO dao = new DeptDAOImpl();
	ArrayList<DeptDTO> deptlist = dao.getDeptList();
	//데이터 공유
	request.setAttribute("deptlist", deptlist);
	System.out.println("ListServlet실행완료");	
	//2. 요청재지정 
	RequestDispatcher rd = request.getRequestDispatcher("/dept/list.jsp");
	rd.forward(request, response);
	
	//3.응답메시지 생성
/*	list.print("<html>");
	list.print("<body>");
	//위 두개는 생략해도 무관하다.
	list.print("<h1 align='center'>부서 목록 출력</h1>");
	list.print("<hr/>");
	list.print("<table border='1' align='center'>");
		list.print("<tr>");
		list.print("<th>부서코드</th><th>부서명</th><th>위치</th>");
		list.print("<th>전화번호</th><th>관리자</th><th>삭제여부</th>");
		list.print("</tr>");
		
	for (int i = 0; i < size; i++) {
		DeptDTO dept = deptlist.get(i);
		list.print("<tr align='center'>");
		list.print("<td>"+dept.getDeptNo()+"</td>");
		list.print("<td>"+dept.getDeptName()+"</td>");
		list.print("<td>"+dept.getLoc()+"</td>");
		list.print("<td>"+dept.getTel()+"</td>");
		list.print("<td>"+dept.getMgr()+"</td>");
		list.print("<td><a href='/serverweb/delete.do?deptno="+dept.getDeptNo()+"&info=test' target='_blank'>삭제</a></td>");
		list.print("</tr>");		
	}
	list.print("</table>");
	list.print("</body>");
	list.print("</html>");	*/
	
	}
}
