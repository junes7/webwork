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
		//1.��û��������
		PrintWriter del = response.getWriter();
		System.out.println("����");
		String deptno = request.getParameter("deptno");
		//2.�����Ͻ��޼ҵ� ȣ��
		DeptDAO dao = new DeptDAOImpl();
		int result = 0;
		result = dao.delete(deptno);
		//3.��û������
		response.sendRedirect("/serverweb/list.do");
/*		del.print("<html>");
		del.print("<body>");
		//�� �ΰ��� �����ص� �����ϴ�.
		del.print("<h1>��������</h1>");
		del.print("<hr/>");
		del.print("<h3>"+result+"�� �μ����� ����</h3>");
		del.print("<a href='/serverweb/list.do' target='_blank'>��Ϻ���</a>");
		del.print("</body>");
		del.print("</html>");*/		
	}

}
