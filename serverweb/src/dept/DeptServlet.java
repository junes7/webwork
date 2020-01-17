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
		System.out.println("����");
		int result = 0;
		String deptNo = request.getParameter("deptNo");
		String deptName = request.getParameter("deptName");
		String loc = request.getParameter("loc");
		String tel = request.getParameter("tel");
		String mgr = request.getParameter("mgr");
		//hyperlink�� ������ get��� �̴�.
/*		System.out.println("�μ��ڵ�=>"+deptNo);
		System.out.println("�μ���=>"+deptName);
		System.out.println("�μ���ġ=>"+loc);
		System.out.println("��ȭ��ȣ=>"+tel);
		System.out.println("������=>"+mgr);*/
		//2.�����Ͻ� �޼ҵ� call
		DeptDTO dept1 = new DeptDTO(deptNo,deptName,loc,tel,mgr);
		DeptDAO dao = new DeptDAOImpl();
		result = dao.insert(dept1); 
	/*	//3. ����޽��� ����
		dept.print("<html>");
		dept.print("<body>");
		//�� �ΰ��� �����ص� �����ϴ�.
		dept.print("<h1>�μ�����</h1>");
		dept.print("<hr/>");
		dept.print("<h3>"+result+"�� �μ���� ����</h3>");
		dept.print("</body>");
		dept.print("</html>");*/
		//3. ����ȭ������ ��û������
		response.sendRedirect("/serverweb/dept/insertResult.html");	
	}
}
